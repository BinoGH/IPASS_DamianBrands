package nl.damian.IPASS.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import nl.damian.IPASS.domein.Gebruiker;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.HttpHeaders;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestCtx){
        boolean isSecure = requestCtx.getSecurityContext().isSecure();
        String scheme = requestCtx.getUriInfo().getRequestUri().getScheme();
        MySecurityContext msc = new MySecurityContext(null,scheme);

        String authHeader = requestCtx.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring("Bearer".length()).trim();
            try{
                JwtParser parser = Jwts.parser().setSigningKey(Authentication.key);
                Claims claims = parser.parseClaimsJws(token).getBody();

                String email = claims.getSubject();
                msc = new MySecurityContext(Gebruiker.getGebruikerByEmail(email), scheme);

            }catch(JwtException | IllegalArgumentException e){
                System.out.println("Invalid JWT, processing as guest!");
            }
        }
        requestCtx.setSecurityContext(msc);
    }
}

