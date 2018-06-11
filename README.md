javaweb框架开发的校园二手交易平台，前后端分离。后台使用ssh框架，使用jQuery对接接口。

添加到购物车 

/http://localhost:8080/NetXiaoTao/shopcart/addNewShopcartItem?shopcartItem.userid=1e3500b06a5c4e49a258f31e0bcce3a7&shopcartItem.c.cartid=1&shopcartItem.c.goodsid=11&shopcartItem.c.num=2

店铺查询
http://localhost:8080/NetXiaoTao/user/findUserAndGoods

查询购物车  

http://localhost:8080/NetXiaoTao/shopcart/findAllShopcartItemByUserid?user.userid=1e3500b06a5c4e49a258f31e0bcce3a7&pageSize=10&page=1   


提交订单：
http://localhost:8080/NetXiaoTao/order/addNewOrderByShopCart?user.userid=1e3500b06a5c4e49a258f31e0bcce3a7&goodsids=15,16&counts=2,3

支付订单：
http://localhost:8080/NetXiaoTao/order/UpdateOrderState?orderItem.id=2&state=1

查看我卖出的订单 
http://localhost:8080/NetXiaoTao/order/findMyOrderByState?user.userid=1e3500b06a5c4e49a258f31e0bcce3a7&state=0

余额提现
http://localhost:8080/NetXiaoTao/user/modifyBalance?user.userid=1e3500b06a5c4e49a258f31e0bcce3a7&bill.price=200&bill.state=2

充值余额

http://localhost:8080/NetXiaoTao/user/modifyBalance?user.userid=1e3500b06a5c4e49a258f31e0bcce3a7&bill.price=200&bill.state=0

消费记录

http://localhost:8080/NetXiaoTao/user/findBillByUseridForPage?user.userid=1e3500b06a5c4e49a258f31e0bcce3a7&pageSize=10&page=1

修改用户信息

http://localhost:8080/NetXiaoTao/user/modifyUserBaseInfo?user的各种信息

添加地址
http://localhost:8080/NetXiaoTao/user/addAddress?user.userid=1e3500b06a5c4e49a258f31e0bcce3a7&address的各种信息

修改地址
http://localhost:8080/NetXiaoTao/user/updateAddress?suser.userid=1e3500b06a5c4e49a258f31e0bcce3a7&address的各种信息

删除地址
http://localhost:8080/NetXiaoTao/user/deleteAddress?suser.userid=1e3500b06a5c4e49a258f31e0bcce3a7


管理员登录
http://localhost:8080/NetXiaoTao/admin/login?admin.username&admin.password

管理员注册
http://localhost:8080/NetXiaoTao/admin/register?admin.username&admin.password

管理员查看用户列表
http://localhost:8080/NetXiaoTao/admin/findAllUser?pageSize=10&page=1

管理员查看聊天
http://localhost:8080/NetXiaoTao/chat/findAllChat

添加收藏

http://localhost:8080/NetXiaoTao/collection/addNewCollection?collection.userid=1e3500b06a5c4e49a258f31e0bcce3a7&collection.goodsid=86

取消收藏

http://localhost:8080/NetXiaoTao/collection/removeCollection?goodsItem.id=86

查看我的收藏
http://localhost:8080/NetXiaoTao/collection/findAllMyCollection?user.userid=1e3500b06a5c4e49a258f31e0bcce3a7&pageSize&page=1

添加关注

http://localhost:8080/NetXiaoTao/attention/addNewAttentionorUpdateState?attention.a_userid=1e3500b06a5c4e49a258f31e0bcce3a7&attention.t_userid=d42b9bec8c364c209399e2e652c173fc

取消关注
http://localhost:8080/NetXiaoTao/attention/addNewAttentionorUpdateState?attention.a_userid=1e3500b06a5c4e49a258f31e0bcce3a7&attention.t_userid=d42b9bec8c364c209399e2e652c173fc

查看我关注的
http://localhost:8080/NetXiaoTao/attention/findAllMyAttentionForPage?user.userid=1e3500b06a5c4e49a258f31e0bcce3a7&pageSize=10&page=1

查看关注我的
http://localhost:8080/NetXiaoTao/attention/findAllOfMyAttentionForPage?user.userid=1e3500b06a5c4e49a258f31e0bcce3a7&pageSize=10&page=1

添加代理商品
就是上拍商品的url 再加上一个 goodsItem.commission=xxx

申请代理
http://localhost:8080/NetXiaoTao/goods/addNewProxy?user.userid=f3f112a0e5af425997e5bee014463f39&goodsItem.id=85

取消代理
http://localhost:8080/NetXiaoTao/goods/removeProxy?goodsItem.id=85

我的代理列表
http://localhost:8080/NetXiaoTao/goods/findGoodsItemByProxyUseridForPage?user.user.userid=f3f112a0e5af425997e5bee014463f39&proxy=2&pageSize=10,page=1

选择代理商品
http://localhost:8080/NetXiaoTao/goods/findGoodsItemByProxyUseridForPage?proxy=1&pageSize=10,page=1




