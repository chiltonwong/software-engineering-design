// pages/home/home.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tableNumbers:0,
    tables: ['1号', '2号', '3号', '4号', '5号', '6号', '7号', '8号', '9号', '10号', '11号','12号'],

    cartList:[],
    sumMoney:0,
    orderNumber:0
  },

  payforit:function(){
    wx.scanCode({
      success(res) {
        console.log(res)
      }
    })
  },

/*选择桌号*/
  bindPickerChange:function(e){
    console.log('picker发生改变，值为',e.detail.value)
    this.setData({
      tableNumbers: e.detail.value
    })
  },  

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({
      title: '快点付款吧！'
    })
    this.setData({
      cartList: wx.getStorageSync('cartList'),
      sumMoney: wx.getStorageSync('sumMoney'),
      orderNumber: wx.getStorageSync('orderNumber'),
    })

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})