package edu.miu.cs.flightreservation.service;



import edu.miu.cs.flightreservation.Util.payload.SignupRequest;
import edu.miu.cs.flightreservation.model.ERole;
import edu.miu.cs.flightreservation.model.Role;
import edu.miu.cs.flightreservation.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserRoleService {
      @Autowired
      public UserRoleRepository roleRepository;
    public Set<Role> userRole(SignupRequest signupRequest) {
        Set<String> strRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.PASSANGER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "agent":
                        Role agent = roleRepository.findByName(ERole.AGENT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(agent);
                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.PASSANGER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

   return roles;
    }
}
