package com.topics.datastructures;

public class GraphNode <T> {
    private T value;

    public GraphNode(T val) {
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
        // type GraphNode by comparing the classes
        // of the passed argument and this object.
        // if(!(obj instanceof GraphNode)) return false; ---> avoid doing this.
        if(obj == null || obj.getClass()!= this.getClass()) {
            return false;
        }

        // type casting of the argument.
        GraphNode graphNode = (GraphNode) obj;

        // comparing the state of argument with
        // the state of 'this' Object.
        return graphNode.value.equals(this.value);
        // return (graphNode.value.equals(this.value) && graphNode.id == this.id);
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
