package com.up.estrela.estrela;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

//Anotação para iformar que é uma classe de configuração do projeto
@Configuration
public class DataConfiguration {
	//Define as configurações do banco de dados
	@Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
     // versão antiga do driver do mysql
     		//dataSorce.setDriverClassName("com.mysql.jdbc.Driver");
     // versão atual do driver do mysql 5
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        /* definir local do banco de dados, onde
		 * 3306 - porta do mysql
		 * star - nome do banco
		 * localhost - endereço do banco de dados
		 */
        dataSource.setUrl("jdbc:mysql://localhost:3306/star");
     // nome de usuário do banco de dados
     		// onde root corresponde ao nome de usuário do banco de dados
        dataSource.setUsername("root");
     // senha do banco da up angelo
     		//dataSorce.setPassword("positovo"); 
        dataSource.setPassword("root");
        return dataSource;        
    }

	// Configuração do JPA
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		// qual banco de dados irá usar
		adapter.setDatabase(Database.MYSQL);
		// mostrar comandos sql no console
		adapter.setShowSql(true);
		// poder criar estrutura do banco de dados na entidade
		adapter.setGenerateDdl(true);
		// utiliza o dialeto SQL específicos para o Mysql5
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		// versão antiga
				//adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}
}
