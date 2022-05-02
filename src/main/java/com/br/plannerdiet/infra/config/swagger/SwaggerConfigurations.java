package com.br.plannerdiet.infra.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.br.plannerdiet.domain.form.IngredientesModelForm;
import com.br.plannerdiet.domain.form.ReceitaModelForm;
import com.br.plannerdiet.domain.form.atualizacao.AtualizacaoReceitaForm;
import com.br.plannerdiet.domain.model.Ingredientes;
import com.br.plannerdiet.domain.model.Receita;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

	@Bean
	public Docket plannerDietApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.br.plannerdiet")).paths(PathSelectors.ant("/**")).build()
				.ignoredParameterTypes(Ingredientes.class)
				.ignoredParameterTypes(Receita.class)
				.ignoredParameterTypes(AtualizacaoReceitaForm.class)
				//.ignoredParameterTypes(DetalhesReceitaModelDto.class)
				//.ignoredParameterTypes(IngredientesModelDto.class)
				.ignoredParameterTypes(IngredientesModelForm.class)
				//.ignoredParameterTypes(ReceitaModelDto.class)
				.ignoredParameterTypes(ReceitaModelForm.class)
				//.ignoredParameterTypes(ReceitasSemanaisDto.class)
				;

	}

}
