package com.topics.datastructures;

/*
 Dummy wrapper over a generic value.
*/
public class Wrapper<T> {
    private T value;

    public Wrapper(T val) {
        value = val;
    }

    T getValue() {
        return value;
    }

    void setValue(T val) {
        value = val;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        // if both the object references are
        // pointing to the same object.
        if(this == obj) {
            return true;
        }

        // it checks if the argument is of the
        // type Wrapper by comparing the classes
        // of the passed argument and this object.
        // if(!(obj instanceof Wrapper)) return false; ---> avoid doing this.
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        // type casting of the argument.
        Wrapper wrapper = (Wrapper) obj;

        // comparing the state of argument with
        // the state of 'this' Object.
        return wrapper.value.equals(this.value);
        // return (wrapper.value.equals(this.value) && wrapper.id == this.id);
    }

    @Override
    public int hashCode() {
        /*
        hashcode contract
        -----------------
        internal consistency: the value of hashCode() may only change if a property that is in equals() changes
        equals consistency: objects that are equal to each other must return the same hashCode
        collisions: unequal objects may have the same hashCode
        */
        return value.hashCode(); // very simplistic implementation of hashcode
    }
}
