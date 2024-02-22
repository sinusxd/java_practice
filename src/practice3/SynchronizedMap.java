package practice3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SynchronizedMap<K,V> implements Map<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public int size() {
        try {
            semaphore.acquire();
            int size = map.size();
            semaphore.release();
            return size;
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return 0;
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            boolean isEmpty = map.isEmpty();
            semaphore.release();
            return isEmpty;
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return true;
        }
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            semaphore.acquire();
            boolean contains = map.containsKey(key);
            semaphore.release();
            return contains;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }


    @Override
    public boolean containsValue(Object value) {
        try {
            semaphore.acquire();
            boolean contains = map.containsValue(value);
            semaphore.release();
            return contains;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Override
    public V get(Object key) {
        try {
            semaphore.acquire();
            V result = map.get(key);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }


    @Override
    public V put(K key, V value) {
        try {
            semaphore.acquire();
            V result = map.put((K)key, (V)value);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        try {
            semaphore.acquire();
            V result = map.remove(key);
            semaphore.release();
            return result;
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        try {
            semaphore.acquire();
            map.putAll(m);
            semaphore.release();
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            map.clear();
            semaphore.release();
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Set<K> keySet() {
        try {
            semaphore.acquire();
            Set result = map.keySet();
            semaphore.release();
            return result;
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override
    public Collection<V> values() {
        try {
            semaphore.acquire();
            Collection result = map.values();
            semaphore.release();
            return result;
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        try {
            semaphore.acquire();
            Set<Entry<K, V>> result = map.entrySet();
            semaphore.release();
            return result;
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        }
    }

}
