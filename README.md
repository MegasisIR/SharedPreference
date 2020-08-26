<pre dir="rtl">
یک تمرین برای اموزش shared preference
</pre>
<div style="margin:0 auto;padding:15px;display:inline-block" dir="rtl" >
 <img src="https://github.com/MegasisIR/SharedPreference/blob/master/screenshots/screenshot-2020-08-27_00.21.31.819.png" alt="drawing" width="400px" height="800px" style="max-width:100%;float: right;" margin="40px">

 <img src="https://github.com/MegasisIR/SharedPreference/blob/master/screenshots/screenshot-2020-08-27_00.21.55.988.png" style="float:right" alt="drawing" width="400px" height="800px"  margin="40px"/>
</div>
<pre dir="rtl">
کلاسی به اسم UserManger  ساختیم  و فایل خود به اسم user_information را در سازنده آن ایجاد کردیم
</pre>
<pre>
public UserManager(Context context) {
        sharedPreferences = context.getSharedPreferences("user_information", context.MODE_PRIVATE);
        }
</pre>
<pre dir="rtl">
  و  تابع به اسم  saveInformation را ساختیم که در shared preference ایجاد شده اطلاعات را ذخیره کند
  </pre>
<pre>
   public boolean saveInformation(String fullName,
                                  String email,
                                  String gender) {
          SharedPreferences.Editor editor = sharedPreferences.edit();
          editor.putString("full_name", fullName);
          editor.putString("email", email);
          editor.putString("gender", gender);
          editor.apply();
          return true;
      }
</pre>
<pre dir="rtl">
  اگر بخواهیم به عنوان مثال به داده full_name دسترسی داشته داشته باشیم
</pre>
<pre>
   public String getFullName() {
          return sharedPreferences.getString("full_name", "");
      }
</pre>

<pre dir="rtl">
  اگر بخواهیم همه داده ها را پاک کنیم به روش زیر عمل میکنیم
</pre>
<pre>
    SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
</pre>

<pre dir="rtl">
اگر بخواهیم مقدار مشخصی را حذف کنیم به روش زیر عمل میکنیم
</pre>
<pre>
      public void removeKey(String key){
              SharedPreferences.Editor editor = sharedPreferences.edit();
              editor.remove(key);
              editor.apply();
          }
</pre>