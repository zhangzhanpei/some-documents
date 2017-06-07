## Laravel 的启动过程
1、入口文件`public/index.php`   
```php
//引入 composer 提供的自动加载
require __DIR__.'/../bootstrap/autoload.php';

//实例化一个 application
$app = require_once __DIR__.'/../bootstrap/app.php';

//取出容器中的 kernel 服务
$kernel = $app->make(Illuminate\Contracts\Http\Kernel::class);

//处理请求并返回结果
$response = $kernel->handle(
    $request = Illuminate\Http\Request::capture()
);

$response->send();

$kernel->terminate($request, $response);
```
2、`bootstrap/app.php`文件
```php
//创建一个 application 实例
$app = new Illuminate\Foundation\Application(
    realpath(__DIR__.'/../')
);

//注册一些重要的服务到容器
$app->singleton(
    Illuminate\Contracts\Http\Kernel::class,
    App\Http\Kernel::class
);

$app->singleton(
    Illuminate\Contracts\Console\Kernel::class,
    App\Console\Kernel::class
);

$app->singleton(
    Illuminate\Contracts\Debug\ExceptionHandler::class,
    App\Exceptions\Handler::class
);

//返回 application 实例, 这里返回的$app是包含了各种服务的容器, 各种容器在步骤3的构造方法中注入
return $app;
```
3、`Illuminate\Foundation\Application`文件, 该类继承于`Illuminate\Container\Container`
```php
//构造函数
public function __construct($basePath = null)
{
    //基础绑定, 将当前Application对象绑定到Container容器的$instances属性数组
    //作两次绑定, ['app' => $this, 'Illuminate\Container\Container' => $this]
    $this->registerBaseBindings();

    //注册`\Illuminate\Events\EventServiceProvider`和`\Illuminate\Routing\RoutingServiceProvider`两个基础服务提供者
    //其中`RoutingServiceProvider`会注册`router`, `url`, `redirect`等服务到容器中
    $this->registerBaseServiceProviders();

    //PHP带命名空间的类名很长, 因此维护一个别名数组如['Illuminate\Foundation\Application' => 'app', 'Illuminate\Encryption\Encrypter' => 'encrypter'], 长类名为键, 别名为值
    //别名数组赋值给Application的aliases属性
    $this->registerCoreContainerAliases();

    //设置Application对象的绝对路径, 并设置一些常用文件夹路径供将来使用, 如 `storage`, `public`, `config`, `bootstrap` 等文件夹的路径
    if ($basePath) {
        $this->setBasePath($basePath);
    }
}
```
