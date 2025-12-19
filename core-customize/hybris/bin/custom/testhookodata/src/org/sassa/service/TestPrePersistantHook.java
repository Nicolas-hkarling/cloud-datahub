package org.sassa.service;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.inboundservices.persistence.PersistenceContext;
import de.hybris.platform.inboundservices.persistence.hook.PrePersistHook;

import java.util.Optional;

import de.hybris.platform.integrationservices.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * PrePersistHook example for demonstrating usage of the request Content-Language and the contextual Integration Object metadata.
 */
public class TestPrePersistantHook implements PrePersistHook  {
    private static final Logger LOG = Log.getLogger(TestPrePersistantHook.class);

    @Override
    public Optional<ItemModel> execute(ItemModel item, PersistenceContext context) {
        if (item instanceof ProductModel productModel) {

            if(productModel.getApprovalStatus().toString().equalsIgnoreCase("approved") ) {
                LOG.info("ProductPrePersistHook. Skipping product {}", productModel.getCode());
                return Optional.empty();
            } else {
                LOG.info("ProductPrePersistHook. Persisting product {}", productModel.getCode());
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }


}