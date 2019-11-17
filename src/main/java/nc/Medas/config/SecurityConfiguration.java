package nc.Medas.config;

import nc.Medas.repo.UserRepo;
import nc.Medas.service.UserPrincipalDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserPrincipalDetailsService userRepo;

    public SecurityConfiguration(UserPrincipalDetailsService userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/**").authenticated()
                .mvcMatchers("/users").hasRole("ADMIN")
                .mvcMatchers("/users/**").hasRole("USER")
              .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // auth.authenticationProvider(authenticationProvider());

        auth
                .inMemoryAuthentication()
                .withUser("Anatolii")
                .password(encoderBean()
                        .encode("13qwe"))
                .roles("USER");
    }


    //    @Bean
//    public PrincipalExtractor principalExtractor(UserRepo userRepo) {
//        return map -> {
//            BigInteger id = new BigInteger( (String)map.get("sub"));
//
//            User user = userRepo.findById(id).orElseGet(() -> {
//                User newUser = new User();
//
//                newUser.setId(id);
//                newUser.setFirstName((String) map.get("given_name"));
//                newUser.setLastName((String) map.get("family_name"));
//                return newUser;
//            });
//            return userRepo.save(user);
//        };
//    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(encoderBean());
        daoAuthenticationProvider.setUserDetailsService(this.userRepo);

        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder encoderBean() {
        return new BCryptPasswordEncoder();
    }


}