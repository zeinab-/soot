/* Soot - a Java Optimization Framework
 * Copyright (C) 2012 Michael Markert, Frank Hartmann
 *
 * (c) 2012 University of Luxembourg - Interdisciplinary Centre for
 * Security Reliability and Trust (SnT) - All rights reserved
 * Alexandre Bartel
 *
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA 02111-1307, USA.
 */


package soot.dexpler;


import java.util.ArrayList;
import java.util.List;

import org.jf.dexlib2.iface.Field;

import soot.SootField;
import soot.Type;
import soot.tagkit.Tag;

/**
 * This class represents all instance and static fields of a dex class.
 * It holds its name, its modifier, and the type
 */
public class DexField {

    protected String name;
    protected int accessFlags;
    protected DexClass dexClass;
    protected Type fieldType;
    protected List<Tag> tags = new ArrayList<Tag>();

    /**
     * Constructor building all relevant information
     */
    public DexField(Field field, DexClass dexClass) {
        this.name = field.getName();
        this.dexClass = dexClass;
        this.accessFlags = field.getAccessFlags();
        this.fieldType = DexType.toSoot(field.getType());
        dexClass.types.add(fieldType);
    }

    /**
     *
     * @return the name of the field
     */
    public String getName() {
        return this.name;
    }
    /**
     *
     * @return the classname concatenated with the field name
     */
    public String getFullName() {
        return this.dexClass.getName() + "->" + this.name;
    }
    /**
     *
     * @return the dexClass where this field is stored
     */
    public DexClass getDexClass() {
        return this.dexClass;
    }
    /**
     *
     * @return modifiers of the class
     */
    public int getModifier() {
        return this.accessFlags;
    }
    /**
     *
     * @return the soot equivalent of a field
     */
    public SootField toSoot() {
        SootField sf = new SootField(name, fieldType, accessFlags);
        for (Tag t: tags)
          sf.addTag(t);
        return sf;
    }
}
