# ArrayList
add()方法  
1. 扩容为(size + 1)  
若当前长度比size大，则不扩容；  
默认扩容为原大小的1.5倍；  
使用 Arrays.copyOf(elementData, newCapacity); 进行扩容
1. elementData[size++] = e;