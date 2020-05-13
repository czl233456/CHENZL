# 实验四  **自定义WebView验证隐式Intent的使用**

**本实验通过自定义WebView加载URL来验证隐式Intent的使用。** 

**实验包含两个应用：** 

第一个应用：获取URL地址并启动隐式Intent的调用。 

第二个应用：自定义WebView来加载URL



1.获取URL地址并启动隐式Intent的调用。

#### activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/url"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="输入网址"
        android:text="http://"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
    <Button
        android:onClick="toweb"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="浏览该网页"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toBottomOf="@id/url"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```



2.自定义WebView来加载URL

### androidmainfest.xml

```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.myapplication">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme"
        android:usesCleartextTraffic="true" >
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <activity android:name=".webview">
            <intent-filter>
                <action android:name="android.intent.action.VIEW"></action>
                <data android:scheme="http"/>
                <data android:scheme="https"/>
                <category android:name="android.intent.category.DEFAULT"/>
            </intent-filter>
        </activity>

    </application>
    <uses-permission android:name="android.permission.INTERNET" />
</manifest>
```

### activity_webview.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    //定义webview视图
    <WebView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/web">
    </WebView>
</LinearLayout>
```

