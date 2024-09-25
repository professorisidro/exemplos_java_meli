package io.isiflix.security_demo.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import io.isiflix.security_demo.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {

	private static final String EMISSOR = "ISIFLIX";
	private static final long EXPIRATION = 2 * 24 * 60 * 60 * 1000;
	private static final String SECRET_KEY = "I51Fl1xS3cr3tKeYF0rM3l1Us3rs@nd5tud3nts";

	public static IsiToken encode(User user) {
		try {
			Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
			String jwtToken = Jwts.builder()
					.subject(user.getLogin())
					.issuer(EMISSOR)
					.claim("ROLE", "ROLE_"+user.getRole())
					.expiration(new Date(System.currentTimeMillis() + EXPIRATION))
					.signWith(key)
					.compact();
			return new IsiToken(jwtToken);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Authentication decode(HttpServletRequest request) {
		try {
			String token = request.getHeader("Authorization");
			if (token != null) {
				token = token.replace("Bearer ", "");
				SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
				JwtParser parser = Jwts.parser().verifyWith(secretKey).build();
				Claims claims = (Claims)parser.parse(token).getPayload();
				String issuer = claims.getIssuer();
				String subject = claims.getSubject();
				String role    = claims.get("ROLE").toString();
				Date   exp     = claims.getExpiration();
				
				System.out.println(issuer + " / "+subject+ " / "+ role + " / "+exp.toString());
				
				if (issuer.equals(EMISSOR) && subject.length()>0 && exp.after(new Date(System.currentTimeMillis()))) {
					System.out.println("Criando token para continuar");
					UsernamePasswordAuthenticationToken usernameToken = new UsernamePasswordAuthenticationToken(subject,null,Collections.singletonList(new SimpleGrantedAuthority(role)));
					
					//]]]usernameToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					return usernameToken;
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
