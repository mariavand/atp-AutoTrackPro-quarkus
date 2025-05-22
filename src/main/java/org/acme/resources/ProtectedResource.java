package org.acme.resources;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api")
@RequestScoped
public class ProtectedResource {
    @Inject
    JsonWebToken jwt; // Inject the JWT for accessing claims

    @GET
    @Path("/public")
    @Produces(MediaType.TEXT_PLAIN)
    public String publicEndpoint() {
        return "This is a public endpoint. Anyone can access it.";
    }

    @GET
    @Path("/protected")
    @Authenticated // Requires an authenticated user (valid token)
    @Produces(MediaType.TEXT_PLAIN)
    public String protectedEndpoint() {
        return "Hello, " + jwt.getName() + "! You accessed a protected endpoint.";
    }

    @GET
    @Path("/admin")
    @RolesAllowed("admin") // Requires a user with the 'admin' role
    @Produces(MediaType.TEXT_PLAIN)
    public String adminEndpoint() {
        return "Welcome, admin " + jwt.getName() + "! You have admin access.";
    }

    // You can also get other claims from the JWT
    @GET
    @Path("/claims")
    @Authenticated
    @Produces(MediaType.APPLICATION_JSON)
    public String getClaims() {
        return "JWT Claims: " + jwt.getRawToken(); // Or specific claims like jwt.getClaim("email")
    }
}
