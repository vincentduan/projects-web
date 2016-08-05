/**
 * ToDoEnum.java
 * Copyright (c) 2013 by efubao.com
 */
package com.efubao.core.common.fileupload;


/**
 * 图片尺寸枚举类
 * 
 */
public enum PicSizeEnum {
	
    /** 主图 */
    MAIN_PIC(1, "主图尺寸", 440,280 ),
    /** 小图 */
    MIN_PIC(2, "小图尺寸",640, Integer.MAX_VALUE),
    MIN_PIC2(3, "小图尺寸",913, Integer.MAX_VALUE),
    /** 其他 */
    OTHER_PIC(0, "不限尺寸", Integer.MAX_VALUE,Integer.MAX_VALUE ),
    /**banner广告*/
    BANNER(4,"banner广告",1242,400),
    /**启动页广告*/
    BOOT_PAGE(5,"启动页广告",1242,2208),
    /**商户门头照*/
    SHOP_LOGO(6,"门头照",1242,450),
    /** 团购单主图 */
    DEAL_MAIN_PIC(7, "团购单主图尺寸", 1242,750),
    /** mall背景图 */
    MALL_BACKGROUND_PIC(8, "mall背景图",480, 850),
    /** 产品图 */
    PRODUCT_PIC(9, "产品图",400, 400);
    
    /**
     * ID
     */
    private final int id;

    /**
     * 名称
     */
    private final String cname;

    /**
     * 宽
     */
    private final int width;

    /**
     * 高
     */
    private final int height;

	/**
	 * @param id
	 * @param cname
	 * @param width
	 * @param height
	 */
	private PicSizeEnum(int id, String cname, int width, int height) {
		this.id = id;
		this.cname = cname;
		this.width = width;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public String getCname() {
		return cname;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

    public static PicSizeEnum valueOf(int id) throws IllegalArgumentException{
        for (PicSizeEnum bt : values()) {
            if (bt.id == id) {
                return bt;
            }
        }
        return null;
    }
   

}
