/*
 * $Id: ProductCatalogLayoutHandler.java,v 1.1 2002/03/09 12:37:36 gimmi Exp $
 *
 * Copyright (C) 2001 Idega hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 *
 */
package com.idega.block.trade.stockroom.business;

import com.idega.block.trade.stockroom.presentation.ProductCatalogLayoutProductList;
import com.idega.block.trade.stockroom.presentation.ProductCatalogLayoutSingleFile;
import java.util.List;
import com.idega.presentation.PresentationObject;
import com.idega.presentation.IWContext;
import com.idega.presentation.ui.DropdownMenu;
import com.idega.builder.handler.PropertyHandler;

/**
 * @author <a href="tryggvi@idega.is">Tryggvi Larusson</a>
 * @version 1.0
 */
public class ProductCatalogLayoutHandler implements PropertyHandler {
  /**
   *
   */
  public ProductCatalogLayoutHandler() {
  }

  /**
   *
   */
  public List getDefaultHandlerTypes() {
    return(null);
  }

  /**
   *
   */
  public PresentationObject getHandlerObject(String name, String value, IWContext iwc) {
    DropdownMenu menu = new DropdownMenu(name);
    menu.addMenuElement("","Select:");
    menu.addMenuElement(ProductCatalogLayoutSingleFile.class.getName(), "Single file");
    menu.addMenuElement(ProductCatalogLayoutProductList.class.getName(), "Product list");
    menu.setSelectedElement(value);
    return(menu);
  }

  /**
   *
   */
  public void onUpdate(String values[], IWContext iwc) {
  }
}