package com.idega.block.trade.stockroom.data;

import javax.ejb.FinderException;
import javax.ejb.CreateException;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Collection;
import java.sql.SQLException;
import com.idega.data.*;


/**
 * Title:        idegaWeb TravelBooking
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:      idega
 * @author <a href="mailto:gimmi@idega.is">Grimur Jonsson</a>
 * @version 1.0
 */

public class SettingsBMPBean extends GenericEntity implements Settings{

  private static final String COLUMN_NAME_DOUBLE_CONFIRMATION = "DOUBLE_CONFIRMATION";
  private static final String COLUMN_NAME_EMAIL_AFTER_ONLINE = "EMAIL_ONLINE";
  private static final String ENTITY_NAME = "TR_SETTINGS";


  public SettingsBMPBean(){
  }

  public SettingsBMPBean(int id)throws SQLException{
    super(id);
  }

  public void initializeAttributes() {
    this.addAttribute(getIDColumnName());
    this.addAttribute(COLUMN_NAME_DOUBLE_CONFIRMATION, "double confirmation", true, true, Boolean.class);
    this.addAttribute(COLUMN_NAME_EMAIL_AFTER_ONLINE, "receive email after online booking", true, true, Boolean.class);

    this.addManyToManyRelationShip(Supplier.class);
    this.addManyToManyRelationShip(Reseller.class);
  }

  public String getEntityName() {
    return ENTITY_NAME;
  }

  public void setDefaultValues() {
    this.setIfDoubleConfirmation(true);
    this.setIfEmailAfterOnlineBooking(false);
  }

  public Integer ejbPostCreate(IDOLegacyEntity entity) throws CreateException{
    return null;
  }
//  public Integer ejbCreate(IDOLegacyEntity entity)throws CreateException{
  public Integer ejbCreate(IDOLegacyEntity entity) throws CreateException{
    try {
      SettingsHome shome = (SettingsHome)IDOLookup.getHome(Settings.class);
      Settings settings = shome.create();
      settings.store();
      ((SettingsBMPBean)settings).addTo(entity);
      return (Integer) settings.getPrimaryKey();
    }catch (RemoteException re) {
      re.printStackTrace(System.err);
    }catch (SQLException sql) {
      sql.printStackTrace(System.err);
    }
    return null;
  }

  /** Getters */
  public boolean getIfDoubleConfirmation() {
    return getBooleanColumnValue(COLUMN_NAME_DOUBLE_CONFIRMATION);
  }

  public boolean getIfEmailAfterOnlineBooking() {
    return getBooleanColumnValue(COLUMN_NAME_EMAIL_AFTER_ONLINE);
  }


  /** Setters */
  public void setIfDoubleConfirmation(boolean doubleConfirmation) {
    setColumn(COLUMN_NAME_DOUBLE_CONFIRMATION, doubleConfirmation);
  }

  public void setIfEmailAfterOnlineBooking(boolean emailAfterOnlineBooking) {
    setColumn(COLUMN_NAME_EMAIL_AFTER_ONLINE, emailAfterOnlineBooking);
  }


  /** Finders */
}