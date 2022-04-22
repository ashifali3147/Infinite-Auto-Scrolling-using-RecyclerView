package com.example.gridview;

public class DOC {

    /*/
    ----[Button Animation]----
    Process:
        1. Create bounce animation file in XML (res->anim-> name.xml)
        2. Call animation file in Activity/Fragment.
        3. Use startAnimation(animation_name) to start animation.
        4. Some time its not work, so better you use a 100 millisecond Handler postDelay after animation and put function calls (startActivity, onBackPress, setFragment, etc) inside postDelay.

    Where to add:
        1. All activity, Fragments, Popup buttons, cart buttons, navigation buttons, toolbar buttons.
        * We didn't add click animation in add or remove order.
    Alternate for swift :
        1. postDelay -> DispatchQueue.main.asyncAfter(deadline: .now() + 10.0) {
                            //call any function
                        }
        2. bounce effect -> <https://findnerd.com/list/view/Animate-button-with-zoom-and-bounce-effect-in-ios/1316/>

    ----[Toolbar Drawer Button Animation]----
        Process:
            1. Create rotation animation in Java file.
            2. Take an boolean for checking button is clicked or not.
            3. Rotate drawer icon when it clicked and change icon to cross.
            4. Reverse the process when it clicked again and also change cross logo to drawer logo.
            5. Restrict the outside click.
            6. Override drawer listener.
            7. In drawerClose function, perform check that drawer is close from outside or not.
            8. If yes then run drawer close animation.
        Where to add:
            1. Menu page toolbar.
        Alternate for swift :
            1. RotateImage -> imageView.transform = imageView.transform.rotated(by: CGFloat(Double.pi / “value by which you want to rotate”)) [2 = 90 degree]
                <link- https://www.tutorialspoint.com/how-to-rotate-an-image-in-imageview-by-an-angle-on-ios-app-using-swift>
            2. ChangeImage -> myImageView.image = UIImage(named: "tick")

        ----[Custom Loader]----
            Process:
                1. Create custom loader layout.
                2. Add lottie animationView and a text view.
                3. Create custom dialog function and inflate this layout.
                4. Change Loader color as per App theme.
                5. Change text as per loading message.
            Where to add:
                1. BaseActivity, BaseFragment.
                2. Adapter page where needed.
            Alternate for swift:
                1. lottie -> <https://mobikul.com/lottie-animation-in-swift/> <https://airbnb.io/lottie/#/ios?id=installing-lottie>

        ----[Reward popup]----
            Process:
                1. Create custom reward_popup layout.
                2. Use lottie animationView for reward animation.
                3. Create custom dialog function and inflate this layout.
                4. Show reward animation for 3 sec & then dismiss.
            Where to add:
                1. Coupon Adapter page.
            Alternate for swift:
                1. dialog -> <https://medium.com/macoclock/how-to-create-and-use-custom-dialog-boxes-in-ios-4335be9dac34>

        ----[Confirm & Failed Order Popup]----
            Process:
                1. In existing popup layout, remove round image and add lottieAnimationView.
                2. Perform check for Order Successful or Failed.
                3. Load animation according to check.
     */

}
