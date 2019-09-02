package ncc.movie.movie.Config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////@Configuration
//public class securityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginProcessingUrl("/earning")
//                .permitAll()
//                .and()
//                .authorizeRequests()//对请求进行授权
//               .antMatchers("/imgs/**","/video/**","/sideshow/**","http://192.168.1.53:8080/*")
//                .permitAll()
//                .anyRequest()     //对于任何请求都进行授权
//                .authenticated()
//                .and()
//                .csrf().disable()
//        ;
//
//    }
//}
