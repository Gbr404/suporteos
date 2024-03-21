package com.curso.domains.enums;

public enum OrderPriority{

   LOW(0,"LOW"),MEDIUM(1,"MEDIUM"),HIGH(2,"HIGH");

   private Integer id;
   private String orderPriority;

   private OrderPriority(Integer id, String orderPriority) {
       this.id = id;
       this.orderPriority = orderPriority;
   }

   public Integer getId() {
       return id;
   }

   public void setId(Integer id) {
        this.id = id;
   }

    public void setOrderPriority(String orderPriority) {
        this.orderPriority = orderPriority;
    }

    public String getOrderPriority() {
       return orderPriority;
    }

    public static OrderPriority toEnum(Integer id) {
        if(id==null) return null;
        for(OrderPriority x : OrderPriority.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Prioridade inválida");
    }

}
