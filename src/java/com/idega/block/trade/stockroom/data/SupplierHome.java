package com.idega.block.trade.stockroom.data;


public interface SupplierHome extends com.idega.data.IDOHome
{
 public Supplier create() throws javax.ejb.CreateException;
 public Supplier createLegacy();
 public Supplier findByPrimaryKey(int id) throws javax.ejb.FinderException;
 public Supplier findByPrimaryKey(Object pk) throws javax.ejb.FinderException;
 public Supplier findByPrimaryKeyLegacy(int id) throws java.sql.SQLException;

}