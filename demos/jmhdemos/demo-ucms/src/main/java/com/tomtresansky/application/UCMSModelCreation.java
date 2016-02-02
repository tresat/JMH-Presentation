package com.tomtresansky.application;

import java.util.IdentityHashMap;

import ucs.common.ui.mvc.Model;
import ucs.ucmsbase.shared.universal.datamodel.shared.abstractdm.docket.DMAbstractDocket;
import ucs.ucmsbase.shared.universal.datamodel.shared.basedm.DMBase;

public class UCMSModelCreation {
  public static Object create_object_baseline() {
    return new Object();
  }
  
  public static DMBase create_dm_base() {
    return new DMBase() {
      private static final long serialVersionUID = -1298419998190944914L;

      @Override
      public DMBase clone() {
        return null;
      }

      @Override
      public Model clone(IdentityHashMap<Model, Model> p_cloneMap) {
        return null;
      }

      @Override
      public int hashCode() {
        return 0;
      }
    };
  }
  
  public static DMAbstractDocket create_dm_abstract_docket() {
    return new DMAbstractDocket();
  }
}
