餐馆自助点餐系统（包含服务端、小程序端与后台管理）
本项目是一个基于Spring Boot和Vue.js的Web系统，包含基于元素构建的后台管理系统和微信小程序。

1、借助开源项目web-flash具有的后台管理类系统的通用的基础功能，并且提供基于IDEA intellij的代码生成插件，可以一键生成前标题页面。

2、目录说明
	api后台api服务
	flash-vue-admin基于vuejs的后台管理系统
	core基础模块，包括工具类，dao，service，bean等内容
flash-generator代码生成模块，配合IDEA代码生成插件webflash-generator使用效果更好

3、技术选型
	核心框架：Spring Boot
	数据库层：spring data jpa
	数据库连接池：druid
	缓存：Ehcache
	前端：基于Vue.js的管理界面和微信小程序

4、使用
	引入idea或eclipse
	创建数据库：web-flash
	确保开发工具下载了lombok插件
	修改api中数据库连接配置
	启动api，访问http://  localhost:8082/swagger-ui.html，保证api服务启动成功

	进入flash-vue-admin目录
	运行npm install --registry = https://registry.npm.taobao.org
	运行npm run dev
	启动成功后访问http：// localhost:9528，登录，用户名密码：admin / admin

	导入miniprogram-test-1项目到微信开发者工具