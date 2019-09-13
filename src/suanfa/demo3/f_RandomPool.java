package suanfa.demo3;

import java.util.HashMap;

/**
 * 设计一个RandomPool结构，有如下三个功能：
 * insert(key)将某个key加入该结构，不重复
 * delete(key)将结构中的某个key移除,把最后一个的key和index移到被删的那个地方
 * getRandom()等概率随机返回结构中的任何一个key
 */
public class f_RandomPool {
    public static void main(String[] args) {
        RandomPool<String> pool=new RandomPool<String>();
        pool.insert("乔乔");
        pool.insert("真");
        pool.insert("可爱");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }
    public static class RandomPool<K>{
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K>indexKeyMap;
        private int size;
        public RandomPool() {
            this.size=0;
            this.keyIndexMap = new HashMap<K, Integer>();
            this.indexKeyMap = new HashMap<Integer, K>();
        }
        public K getRandom(){
            if(size==0){
                return null;
            }
            //获取0-size中的任意一个整数
            //Math.random()生成的是0-1的随机数
            int randomIndex=(int)(Math.random()*size);
            return indexKeyMap.get(randomIndex);
        }
        public void insert(K key){
            if(!keyIndexMap.containsKey(key)){
                keyIndexMap.put(key,size);
                indexKeyMap.put(size++,key);
            }
        }
        public void delete(K key){
            if(keyIndexMap.containsKey(key)){
                //获取要被删除的key对应的index
                int deleteIndex=keyIndexMap.get(key);
                //获取删除之前最后那个数的index和其对应的key
                int lastIndex=--size;
                K lastKey=indexKeyMap.get(lastIndex);
                //在keyIndexMap删除需要删除的那个key
                keyIndexMap.remove(key);
                //在indexKeyMap删除需要删除的那个index
                indexKeyMap.remove(deleteIndex);
                keyIndexMap.put(lastKey, lastIndex);
                indexKeyMap.put(lastIndex, lastKey);
            }
        }
    }
}
