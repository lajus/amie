/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amie.data;

import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author jlajus
 */
public class SetU {
    
    public static <T> long countIntersection(Set<T> s1, Set<T> s2) {
        if (s1 == null || s2 == null) { return 0; }
        if (s1.size() > s2.size()) { return countIntersection(s2, s1); }
        long result = 0;
        for (T e1 : s1) {
            if (s2.contains(e1)) result++;
        }
        return result;
    }
    
    public static class intersectionIterable<T> implements Iterable<T> {

        Set<T> s1, s2;
        
        public intersectionIterable(final Set<T> s1, final Set<T> s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
        
        @Override
        public Iterator<T> iterator() {
            return new intersectionIterator(s1, s2);
        }
        
        public static <T> Iterable<T> getInstance(final Set<T> s1, final Set<T> s2) {
            return new intersectionIterable(s1, s2);
        }
    }
    
    public static class intersectionIterator<T> implements Iterator<T> {

        final Set<T> big;
        Iterator<T> sit;
        T next;
        
        public intersectionIterator(final Set<T> s1, final Set<T> s2) {
            if (s1 == null || s2 == null) {
                big = null;
                sit = null;
            } else {
                if (s1.size() <= s2.size()) {
                    sit = s1.iterator();
                    big = s2;
                } else {
                    sit = s2.iterator();
                    big = s1;
                }
            }
            next = null;
        }
        
        @Override
        public boolean hasNext() {
            if (next != null) { return true; }
            if (sit == null) { return false; }
            while(sit.hasNext()) {
                if (big.contains(next = sit.next())) { return true; }
            }
            next = null;
            return false;
        }

        @Override
        public T next() {
            T r = null;
            if (next != null || hasNext()) { r = next; next = null; }
            return r;
        }
    }
}
