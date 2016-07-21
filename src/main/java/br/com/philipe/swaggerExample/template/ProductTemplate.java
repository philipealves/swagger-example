package br.com.philipe.swaggerExample.template;

import java.math.BigDecimal;

import br.com.philipe.swaggerExample.model.Product;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ProductTemplate extends AbstractTemplate implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Product.class).addTemplate(NEW, new Rule() {
			{
				add("uid", null);
				add("name", name());
				add("description", regex("\\w{10}"));
				add("price", random(BigDecimal.class, range(1, 500)));
			}
		});

		Fixture.of(Product.class).addTemplate(NEW_WITH_ID, new Rule() {
			{
				add("uid", random(Long.class, range(1L, 500L)));
				add("name", name());
				add("description", regex("\\w{10}"));
				add("price", random(BigDecimal.class, range(1, 500)));
			}
		});
	}

}
