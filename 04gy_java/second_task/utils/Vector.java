package utils;

public class Vector{
  int [] data;

  public Vector(int [] arr){
    data = arr;
  }

  public void multiply(int lambda){
    for(int i : data)
      i *= lambda;
  }

  public int dotProduct(Vector other){
    if(other.data.length != data.length){
      //TODO handle
    }

    int prod = 0;
    for(int i = 0; i<data.length; i++){
      prod += data[i] * other.data[i];
    }

    return prod;
  }

  public void add(Vector other){ 
    if(other.data.length != data.length){
      //TODO handle
    }
    
    for(int i = 0; i<data.length; i++){
      data[i] += other.data[i];
    }
  }

  public void subtract(Vector other){ 
    if(other.data.length != data.length){
      //TODO handle
    }
    
    for(int i = 0; i<data.length; i++){
      data[i] -= other.data[i];
    }
  }

  public int eucledesNorm(){
    int ret = 0;
    for (int i : data)
      ret += Math.pow(i, 2);
    return ret;
  }


}
