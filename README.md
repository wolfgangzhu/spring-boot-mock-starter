Mock Utility

#项目介绍
经常，在我们本地开发调试过程中，我会会调用其他服务，就必须保证其他服务必须正常运行，所以我们会去先启动其他服务
再去启动我们要测试的服务，这回比较麻烦，我想到的另一种方式是我们将需要调用的接口mock掉，这样，我们只用启动本服务，
当调用到依赖接口时，其实是调用的是我们自己编写的mock interface.(注意这里不是mock server).

