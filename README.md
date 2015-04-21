# Android-pull-to-refresh
# 怎麼把這專案匯入Android Studio
* 要選**Import Project...**

<img src="https://raw.githubusercontent.com/iampaul83/Android-Parcelable/gh-pages/img-as.png" alt="Android Studio 匯入專案" height="200" width="200">
***
# [SwipeRefreshLayout](https://developer.android.com/reference/android/support/v4/widget/SwipeRefreshLayout.html)

[SwipeRefreshLayoutFragment.java](https://github.com/iampaul83/Android-pull-to-refresh/blob/master/app/src/main/java/com/iampaul83/pulltorefresh/SwipeRefreshLayoutFragment.java)

[fragment_swipe_refresh_layout.xml](https://github.com/iampaul83/Android-pull-to-refresh/blob/master/app/src/main/res/layout/fragment_swipe_refresh_layout.xml)

注意如果沒有下面這段程式，重整中切換fragment會卡住
```java
@Override
public void onPause() {
  super.onPause();
  if (swipeRefreshLayout!=null) {
    swipeRefreshLayout.setRefreshing(false);
    swipeRefreshLayout.clearAnimation();
  }
}
```
# [android-Ultra-Pull-To-Refresh](https://github.com/liaohuqiu/android-Ultra-Pull-To-Refresh)
[PullToRefreshFragment.java](https://github.com/iampaul83/Android-pull-to-refresh/blob/master/app/src/main/java/com/iampaul83/pulltorefresh/PullToRefreshFragment.java)

[fragment_pull_to_refresh.xml](https://github.com/iampaul83/Android-pull-to-refresh/blob/master/app/src/main/res/layout/fragment_pull_to_refresh.xml)

這個library有好多header可以用，這邊使用的是**StoreHouseHeader**

注意若是使用**PtrHandler**要實作**checkCanDoRefresh**否則想ListView這種會無法往上滑(會直接觸發refresh)
```java
ptrFrameLayout.setPtrHandler(new PtrHandler() {
  @Override
  public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
    boolean canDoRefresh;
    //TODO: check if canDoRefresh or not
    return canDoRefresh;
  }
  @Override
    public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
      //TODO: refresh code...
   }
});
```
而使用**PtrDefaultHandler**會自動**checkCanDoRefresh**，在**ListView**和**GridView**上測試狀況良好
```java
ptrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
  @Override
  public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
    //TODO: refresh code...
  }
});
```
