package auth.permission;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import app.dao.UserDAO;
import app.dao.UserRoleDAO;
import app.entity.User;
import app.entity.UserRole;

@Component
public class AuthenticationConfigurer implements AuthenticationProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationConfigurer.class);

	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private UserDAO userRepository;

	@Autowired
	private UserRoleDAO userRoleRepository;

	private UsernamePasswordAuthenticationToken authenticateDataBase(Authentication authentication)
			throws AuthenticationException {
		String name = authentication.getName();
		String rawPassword = authentication.getCredentials().toString();
		List<User> users = userRepository.findByLogin(name, new PageRequest(0, 100)).getContent();

		if (users.isEmpty())
			throw new UsernameNotFoundException("Usuário não encontrado!");

		User user = users.get(0);
		if (passwordEncoder.matches(rawPassword, user.getPassword())) {
			Set<GrantedAuthority> roles = getAuthorities(user);
			org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
					user.getName(), user.getPassword(), false, false, false, false, roles);
			UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(userDetails,
					user.getPassword(), roles);
			userToken.setDetails(userDetails);

			HttpSession session = request.getSession();
			session.setAttribute("theme", (user.getTheme() != null) ? user.getTheme() : "");

			return userToken;
		} else {
			throw new BadCredentialsException("Usuário ou senha incorreta!");
		}
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return authenticateDataBase(authentication);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	private Set<GrantedAuthority> getAuthorities(User user) {
		Set<GrantedAuthority> authorities = new HashSet<>();

		Pageable pageable = new PageRequest(0, 100);
		List<UserRole> roles = userRoleRepository.findByLogin(user.getLogin(), pageable).getContent();
		for (UserRole userRole : roles) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.getRole().getName());
			authorities.add(grantedAuthority);
		}

		LOGGER.debug("user authorities are " + authorities.toString());
		return authorities;
	}

}
