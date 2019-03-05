# Orders
mybatis的关联查询。
	
一个类中，我们知道了该类中的某个属性名，并且我们知道了该属性的类型。

		Class<?> o_claz = Class.forName("com.hxzy.entity.Orders");
		Orders order = o_claz.newInstance();
		
		读取配置文件，根据配置文件中的orders类的属性进行赋值。
		o_claz.getDeclaredField("orders属性名").set(order,从resultSet中，根据sql语句查询结果的列名获取值);


		com.hxzy.entity.User
		
		Class<?> clz = Class.forName("com.hxzy.entity.User");
		User user = clz.newInstance();
		为user对象中的属性赋值
		通过mybatis的映射文件，配置要为user对象中的哪些属性赋值。
		clz.getDeclaredField("属性名").set(user,从resultSet中，根据sql语句查询结果的列名获取值);
		
		重复执行如上代码，为映射文件中配置的，所有的user对象的属性赋值完毕。
		
		通过映射文件中association节点中的property属性，我们可以得知要为orders类中的那个属性赋值。
		
		
		//将组装完毕的user对象的引用给orders类中的user属性。
