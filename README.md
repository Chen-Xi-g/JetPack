# Android Jetpack 学习手册

@(工作)[学习手册, Jetpack]

[toc]

## 前言

&emsp; &emsp; 随着Android的发展，开发的框架也是各有风格，Google为了提高开发效率，减少BUG用更多的精力对应用进行打造，所以在2018年推出了Jetpack。
&emsp; &emsp; 为了学习Jetpack将会进行实战与学习手册编写，项目使用模块化学习，每个模块都可以独立运行查看效果，也更方便学习。本文重点在Jetpack的Architecture，其他部分略过。

## Jetpack组件
&emsp;&emsp;Jetpack组件是由不同的库组合而成，可以单独使用，可以协同使用。Jetpack主要分为四个部分。
### 一、 Foundation ( 基础组件提供交叉功能，如向后兼容性、测试和Kotlin语言支持。)
&emsp;&emsp;如果你的AndroidStudio是最新版本，在创建项目时会帮你自动创建相关配置，详细信息到官网查阅。
### 二、Architecture (架构组件可帮助您设计健壮，可测试和可维护的应用程序。)

&emsp;&emsp;这是本文的重点所在，阅读可能需要很长时间，请准备好瓜子矿泉水。

#### 1.Data Binding
&emsp;&emsp; Data Binding是将布局的UI组件与数据进行绑定，并且不需要再findViewById来查找控件，省了很多的java代码，并且有助于防止内存泄漏和空指针。它一直以来都被人误会，在UI中进行了过多的逻辑处理，其实Data Binding是非常强大的，之所以被误会其实是没有真正的了解他的作用。

##### 1.1 在项目中使用Data Binding

&emsp;&emsp; 在app下的build.gradle中添加dataBinding元素。

```
android{
	...
	dataBinding {
        enabled = true
    }
}
```
##### 1.2 布局和绑定数据
&emsp;&emsp; 使用Data Binding的UI布局和之前的UI布局会有不同，之前我们的根标签为View，现在的根标签为layout，还有一个必须元素data，接下来才是我们的view元素。
```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>
	    <!-- 绑定事件处理类 -->
        <variable
            name="click"
            type="com.minlukj.databinding.DataBindingActivity.ClickProxy" />
    </data>

    <LinearLayout xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center"
        android:orientation="vertical"
        tools:context=".DataBindingActivity">
        <!-- onClick执行事件处理类中的startBasisActivity -->
		<androidx.appcompat.widget.AppCompatButton
            android:onClick="@{() ->click.startBasisActivity()}"
            android:padding="10dp"
            android:layout_margin="20dp"
            android:text="@string/basis"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />

        <androidx.appcompat.widget.AppCompatButton
            android:onClick="@{() ->click.startMediumActivity()}"
            android:padding="10dp"
            android:layout_margin="20dp"
            android:text="@string/medium"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />

        <androidx.appcompat.widget.AppCompatButton
            android:onClick="@{()->click.startAdvancedActivity()}"
            android:padding="10dp"
            android:layout_margin="20dp"
            android:text="@string/advanced"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
    </LinearLayout>
</layout>
```
&emsp;&emsp; 布局创建完之后Activity和布局需要进行绑定，他会自动生成一个ActivityXXXXBinding。
```kotlin
class DataBindingActivity : AppCompatActivity() {

	//获取自动生成的 ActivityDataBindingBinding
	private lateinit var mDataBinding : ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //使用DataBindingUtil.setContentView与布局进行绑定，使用Data Binding 后不需要调用setContentView
        mDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        //事件处理类绑定
        mDataBinding.click = ClickProxy()
    }
    /**
     * 使用DataBinding设置点击事件
     */
    inner class ClickProxy{
        /**
         * 基础DataBinding
         */
        fun startBasisActivity(){
            startActivity(Intent(this@DataBindingActivity,BasisActivity::class.java))
        }

        /**
         * 中级DataBinding
         */
        fun startMediumActivity(){
            startActivity(Intent(this@DataBindingActivity,MediumActivity::class.java))
        }

        /**
         * 高级DataBinding
         */
        fun startAdvancedActivity(){
            startActivity(Intent(this@DataBindingActivity,AdvancedActivity::class.java))
        }
    }
}
```
现在就完成了基本的数据绑定，并且我们的Button也有了点击事件，再Activity中不需要findViewById，也不需要setOnClickListener就可以进行事件处理。

