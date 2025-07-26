import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    /**
     * 使用 LinkedHashMap 实现 LRU 缓存
     * @param capacity 缓存容量
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // 初始容量为 capacity，负载因子 0.75，accessOrder 为 true 表示按访问顺序排序
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            /**
             * 重写 removeEldestEntry 方法，当缓存大小超过容量时移除最近最少使用的条目
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    /**
     * 获取缓存中的值
     * @param key 键
     * @return 如果存在则返回对应的值，否则返回 -1
     */
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    /**
     * 向缓存中添加或更新键值对
     * @param key 键
     * @param value 值
     */
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
