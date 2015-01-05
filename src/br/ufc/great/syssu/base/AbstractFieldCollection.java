package br.ufc.great.syssu.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractFieldCollection<T extends AbstractField> 
	implements Iterable<T> {

    protected List<T> fields;

    public AbstractFieldCollection() {
        fields = new ArrayList<T>();
    }

    public AbstractFieldCollection<T> addField(T field) {
        fields.add(field);
        return this;
    }

    public AbstractFieldCollection<T> addField(String name, Object value) {
        fields.add(createField(name, value));
        return this;
    }

    public AbstractFieldCollection<T> removeField(T field) {
        fields.remove(field);
        return this;
    }

    public AbstractFieldCollection<T> removeField(int index) {
        fields.remove(index);
        return this;
    }

    public T getField(int index) {
        return fields.get(index);
    }
    
    public T getField(String index) {
    	if(index.equalsIgnoreCase("contextkey")) 
    		return fields.get(0);
    	else if(index.equalsIgnoreCase("source")) 
    		return fields.get(1);
    	else if(index.equalsIgnoreCase("values")) 
    		return fields.get(2);
    	else if(index.equalsIgnoreCase("accuracy")) 
    		return fields.get(3);
    	else if(index.equalsIgnoreCase("timestamp")) 
    		return fields.get(4);
    	else {
    		System.out.println("Campo incorreto. Get Values");
    		return fields.get(2);
    	}
    }

    public int size() {
        return fields.size();
    }

    public boolean isEmpty() {
        return fields.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return fields.iterator();
    }
    
    // Template method:
    public abstract T createField(String name, Object value);

}
