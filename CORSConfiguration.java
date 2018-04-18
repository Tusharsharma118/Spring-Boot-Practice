/*
 * Enel S.p.a
 *
 * gestione_anagrafica_services user: vpoddar date: 23 Nov, 2017
 *
 * @Copyright Enel
 */
package it.enel.nxdm.gestioneanagrafica;

/*
 * Enel S.p.a
 *
 * gestione_anagrafica_services user: vpoddar date: 17 Nov, 2017
 *
 * @Copyright Enel
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSConfiguration {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurerAdapter() {
      @Override
      public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
      }
    };
  }

}
