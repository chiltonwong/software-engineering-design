// pages/home/home.js
Page({
  data: {
    leftname: ['人气热卖','新品上市','欢乐送下午茶','当季主打'],
    foodname:[],
    totalCost:150,
    orderNumber:0,
    activeIndex:4,
    scrollTop:100,
    toView:'a0',
    cartList:[],
    currentType:0,
    currentIndex:0,
    sumMoney:0,
    showCart:false,
    toastHidden:true,

    bannerUrl:[
      '../../imgs/slide1.png',
      '../../imgs/slide2.png',
      '../../imgs/slide3.png'
      ],
    indicatordots:true,
    autoplay:true,
    interval:4000,
    duration:1000,

    listData:[
      {
        name:'热门',
        foods:[
          {
            name:'翅桶',
            image_url:'../../imgs/dish1.jpg',
            price:39
          },
          {
            name:'双堡翅尖桶',
            image_url:'../../imgs/dish2.jpg',
            price:78
          },
        ]
      },
      {
        name:'新品上市',
        foods:[
          {
            name:'川香燃辣撸串桶',
            image_url:'../../imgs/dish3.jpg',
            price:59
          },
          {
            name: '香卤系列辣翅烤翅',
            image_url: '../../imgs/dish4.jpg',
            price: 69
          }
        ]
      },
      {
        name:'欢乐送下午茶',
        foods:[
          {
            name: '4人下午茶欢享桶',
            image_url: '../../imgs/dish5.jpg',
            price: 51
          },
          {
            name: '3人下午茶欢享桶',
            image_url: '../../imgs/dish6.jpg',
            price: 53
          },
          {
            name: '下午茶华夫礼盒',
            image_url: '../../imgs/dish7.jpg',
            price: 27
          }
        ]
      },
       {
        name: '当季主打',
        foods: [
          {
            name: '超级外送全家桶S',
            image_url: '../../imgs/dish8.jpg',
            price: 123
          }
        ]
      }
    ] 
  },

  submitClick:function(){
    if(this.data.sumMoney!=0){
      wx.setStorageSync('cartList', this.data.cartList);
      wx.setStorageSync('sumMoney', this.data.sumMoney);
      wx.setStorageSync('orderNumber', this.data.orderNumber);     
      wx.navigateTo({
        url: '../list/list'
      }) 
    }
    if(this.data.sumMoney == 0){
      

    }

  },

//选择左侧列表菜单函数
  selectMenu: function (e) {
    var index = e.currentTarget.dataset.index
    this.setData({
      activeIndex: index,
      toView: 'a' + index,
    })
  },
  scroll:function(e){
    var dis=e.detail.scrollTop
    if(dis>0 && dis<300){
      this.setData({ activeIndex: 0 })
    }
    if(dis>300 && dis<600){
      this.setData({ activeIndex: 1 })
    }
    if(dis>600 && dis<900){
      this.setData({ activeIndex: 2 })
    }
    if (dis > 900 && dis < 1050) {
      this.setData({ activeIndex: 3 })
    }
    if (dis > 1200 && dis < 1350) {
      this.setData({ activeIndex: 4 })
    }
    if (dis > 1350 && dis < 1800) {
      this.setData({ activeIndex: 5 })
    }

  },
  addToCart: function (e) {
    var type = e.currentTarget.dataset.type;
    var index = e.currentTarget.dataset.index;
    this.setData({
      currentType: type,
      currentIndex: index,
    });
    var a = this.data
    var addItem = {
      "name": a.listData[a.currentType].foods[a.currentIndex].name,
      "price": a.listData[a.currentType].foods[a.currentIndex].price,
      "number": 1,
      "sum": a.listData[a.currentType].foods[a.currentIndex].price,
    }
    var sumMoney = a.sumMoney + a.listData[a.currentType].foods[a.currentIndex].price;
    var cartList = this.data.cartList;
    cartList.push(addItem);
    this.setData({
      cartList: cartList,
      showModalStatus: false,
      sumMoney: sumMoney,
      orderNumber: a.orderNumber + 1
    });
    console.log(this.data.cartList)
    this.setData({
      toastHidden:false
    });
    
    var _this = this;
    setTimeout(function () {
      _this.setData({
        toastHidden: true
      });
    }, 1000);
  },

  showCart:function(){
    console.log(this.data.showCart)
    if (this.data.cartList.length != 0) {
      this.setData({
        showCart: !this.data.showCart,
      });
    }
  },

  clearCart:function(){
    this.setData({
      cartList:[],
      showCart:false,
      sumMoney:0,
      orderNumber:0,
    })
  },

  addNumber: function (e) {
    var index = e.currentTarget.dataset.index;
    console.log(index)
    var cartList = this.data.cartList;
    cartList[index].number++;
    var sum = this.data.sumMoney + cartList[index].price;
    cartList[index].sum += cartList[index].price;

    this.setData({
      cartList: cartList,
      sumMoney: sum,
      orderNumber: this.data.orderNumber + 1
    });
  },

  decNumber: function (e) {
    var index = e.currentTarget.dataset.index;
    console.log(index)
    var cartList = this.data.cartList;

    var sum = this.data.sumMoney - cartList[index].price;
    cartList[index].sum -= cartList[index].price;
    cartList[index].number == 1 ? cartList.splice(index, 1) : cartList[index].number--;
    this.setData({
      cartList: cartList,
      sumMoney: sum,
      showCart: cartList.length == 0 ? false : true,
      orderNumber: this.data.orderNumber - 1
    });
  },



  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    wx.setNavigationBarTitle({
      title: '点餐'
    })
    //从数据库中获取数据
    var that = this;
    var sysinfo = wx.getSystemInfoSync().windowHeight;
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