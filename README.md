javaweb框架开发的校园二手交易平台，前后端分离。后台使用ssh框架，使用jQuery对接接口。

添加到购物车 

/http://localhost:8080/NetXiaoTao/shopcart/addNewShopcartItem?shopcartItem.userid=1e3500b06a5c4e49a258f31e0bcce3a7&shopcartItem.c.cartid=1&shopcartItem.c.goodsid=11&shopcartItem.c.num=2

店铺查询
http://localhost:8080/NetXiaoTao/user/findUserAndGoods

查询购物车

http://localhost:8080/NetXiaoTao/shopcart/findAllShopcartItemByUserid?user.id=1e3500b06a5c4e49a258f31e0bcce3a7&pageSize=10&page=1