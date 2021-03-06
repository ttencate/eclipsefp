// Copyright (c) 2006-2008 by Leif Frenzel. All rights reserved.
// This code is made available under the terms of the Eclipse Public License,
// version 1.0 (EPL). See http://www.eclipse.org/legal/epl-v10.html
package net.sf.eclipsefp.haskell.debug.core.internal.util;

import org.eclipse.osgi.util.NLS;

/** <p>provides internationalized String messages for the core.</p>
  *
  * @author Leif Frenzel
  */
public final class CoreTexts extends NLS {

  // message fields
  public static String haskellLaunchDelegate_noExe;


  private static final String BUNDLE_NAME
    = CoreTexts.class.getPackage().getName() + ".coretexts"; //$NON-NLS-1$

  static {
    NLS.initializeMessages( BUNDLE_NAME, CoreTexts.class );
  }
}