package com.vincenzomerola.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.reactive.ReactiveManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

/*ReactiveManagementWebSecurityAutoConfiguration.class: 
 * Escludendo questa configurazione, eviti che Spring Boot 
 * carichi automaticamente la sicurezza reattiva per gli 
 * endpoint di management (come quelli esposti da Actuator), 
 * se non ne hai bisogno o se gestisci la sicurezza in modo diverso. Questo evita conflitti con la tua configurazione di sicurezza personalizzata.
 * 
 * WebSecurityConfiguration.class: 
 * Escludendo questa configurazione, impedisci che venga
 *  caricato il contesto di sicurezza non reattivo (bloccante), 
 *  che potrebbe entrare in conflitto con la tua configurazione 
 *  reattiva. Questa esclusione è particolarmente importante 
 *  per evitare che Spring tenti di applicare logiche di sicurezza
 *  non reattive in un contesto reattivo.
 *  
 *  Mantieni la Coerenza nel Contesto Reattivo:
 *  L'esclusione garantisce che solo la configurazione 
 *  reattiva venga caricata, evitando potenziali conflitti
 *  o sovrapposizioni tra configurazioni reattive e non reattive. 
 *  Questo mantiene la tua applicazione coerente con il modello 
 *  reattivo di Spring WebFlux.
*/

/*Quando escludi ReactiveManagementWebSecurityAutoConfiguration.class, stai impedendo a Spring Boot di applicare automaticamente la sicurezza reattiva agli endpoint di management, come quelli esposti da Spring Boot Actuator. Spring Boot Actuator è una libreria che fornisce endpoint per monitorare e gestire la tua applicazione, come /actuator/health, /actuator/metrics, ecc.

Cosa fa ReactiveManagementWebSecurityAutoConfiguration?
ReactiveManagementWebSecurityAutoConfiguration è una configurazione automatica che protegge gli endpoint di Actuator in un contesto reattivo, applicando regole di sicurezza specifiche a questi endpoint.
Questa configurazione include la protezione degli endpoint di management con Spring Security, il che significa che puoi applicare autorizzazioni, autenticazione, e altre politiche di sicurezza agli endpoint come /actuator/health.
Perché potresti volerla escludere?
Personalizzazione della Sicurezza: Se stai gestendo la sicurezza degli endpoint di Actuator manualmente o non hai bisogno di proteggere questi endpoint con configurazioni reattive specifiche, potresti voler escludere questa configurazione per evitare sovrapposizioni o conflitti con le tue regole personalizzate.
Semplicità: Escludendo questa configurazione, riduci il carico automatico di configurazioni non necessarie, mantenendo il controllo completo su come gli endpoint di Actuator vengono gestiti.
Quando potresti volerla includere?
Necessità di Proteggere gli Endpoint di Actuator in un Contesto Reattivo:

Se decidi che gli endpoint di Actuator devono essere protetti con autenticazione e autorizzazione, e vuoi sfruttare la sicurezza reattiva offerta da ReactiveManagementWebSecurityAutoConfiguration, potresti voler rimuovere l'esclusione.
Ad esempio, potresti voler richiedere l'autenticazione per accedere a /actuator/health o /actuator/metrics, applicando politiche di sicurezza reattive.
Complessità di Gestione:

Se l'applicazione diventa più complessa e inizia a fare uso intensivo di Spring Boot Actuator per il monitoraggio e la gestione, potresti trovare conveniente utilizzare le configurazioni predefinite di Spring, incluse quelle per la sicurezza reattiva, per ridurre la quantità di configurazioni manuali.
Conclusione:
Lasciare l'Esclusione: Se attualmente non hai bisogno di proteggere gli endpoint di Actuator con sicurezza reattiva o stai gestendo la loro sicurezza manualmente, l'esclusione è appropriata e mantiene il tuo contesto di sicurezza più semplice e pulito.

Rimuovere l'Esclusione in Futuro: Se in futuro decidi di sfruttare le funzionalità di Spring Boot Actuator in un contesto reattivo, con necessità di protezione degli endpoint di management, potresti considerare di rimuovere l'esclusione di ReactiveManagementWebSecurityAutoConfiguration per sfruttare la configurazione automatica fornita da Spring.*/


@SpringBootApplication(exclude = {ReactiveManagementWebSecurityAutoConfiguration.class})
@EnableDiscoveryClient

public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
