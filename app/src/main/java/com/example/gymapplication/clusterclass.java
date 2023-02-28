package com.example.gymapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public  class clusterclass extends MyDataBase  {
    public clusterclass(Context context) {
        super(context);


    }

//MyDataBase myDataBase;
//SQLiteDatabase sqLiteOpenHelper;


    public  boolean inserteerdata( String Musclename, String Exercisename,int image,String Exercisedescription,int thumbnailimage){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("musclename", Musclename);
        contentValues.put("Exercisename", Exercisename);
        contentValues.put("image", image);
        contentValues.put("Exercisedescription", Exercisedescription);
        contentValues.put("thumbnailimage", thumbnailimage);
        long ins = MyDB.insert("tableimage", null, contentValues);
        if(ins==-1) return false;
        else return true;
    }

    public void dataclass(){
int o=0;

        //inserteerdata("name", "muscle",R.raw.benchpress2,"desription",R.raw.benchpress2);

      //  case null: inserteerdata("null", "muscle",null, "desription",null);
      //  break;

        while (o!=63) {
       o++;
       switch (o) {


           case 0: inserteerdata("TRICEPS", "single cable pushdown", R.raw.triceps_single_cable_pushdown, "Starting position\n" +
                   "Stand under a high cable pulley.\n" +
                   "Grasp the stirrup using a reverse (underhand) grip.\n" +
                   "Tuck your elbow into your side.\n" +
                   "Execution\n" +
                   "Keeping your elbow fixed against your side, exhale as you extend your elbow and push the stirrup downward until your arm is almost fully extended.\n" +
                   "Inhale as you flex your elbow and allow the stirrup to rise to the starting position in a controlled manner.\n" +
                   "Repeat for the prescribed number of repetitions.\n" +
                   "Repeat the exercise with your opposite arm.", R.raw.triceps_single_cable_pushdown);
               break;

           case 1: inserteerdata("TRICEPS", "pushdown", R.raw.tricep_pushdown, "Start by setting a bar attachment (straight or e-z) on a high pulley machine.\n" +
                   "Facing the bar attachment, grab it with the palms facing up (supinated grip) at shoulder width. Lower the bar by using your lats until your arms are fully extended by your sides. Tip: Elbows should be in by your sides and your feet should be shoulder width apart from each other. This is the starting position.\n" +
                   "Slowly elevate the bar attachment up as you inhale so it is aligned with your chest. Only the forearms should move and the elbows/upper arms should be stationary by your side at all times.\n" +
                   "Then begin to lower the cable bar back down to the original staring position while exhaling and contracting the triceps hard.\n" +
                   "Repeat for the recommended amount of repetitions.", R.raw.tricep_pushdown);
               break;

           case 2:inserteerdata("TRICEPS", "single cable pushdown", R.raw.triceps_single_cable_pushdown, "Starting position\n" +
                   "Holding a pair of dumbbells using a neutral or hammer grip (palms facing your body), sit on a bench.\n" +
                   "Keeping your upper arms fixed to your sides, lean forward until your torso is almost horizontal. Your back should be straight.\n" +
                   "Raise your upper arms a little higher until they become horizontal. Your elbows should be bent at 90 degrees.\n" +
                   "Execution\n" +
                   "Keeping your upper arms horizontal, exhale as you extend the dumbbells behind you until your forearms are horizontal.\n" +
                   "Hold for a count of two.\n" +
                   "Inhale as you slowly lower the dumbbells to the starting position.\n" +
                   "Repeat.", R.raw.triceps_single_cable_pushdown);
               break;

           case 3: inserteerdata("TRICEPS", "sitting dumbell extensions", R.raw.tricep_sitting_dumbell_extensions, "Starting position\n" +
                   "Holding a dumbbell, sit on a flat bench or chair and rest the dumbbell on its side on one knee.\n" +
                   "Grasp the base of the bar of the dumbbell with both hands, one hand over the other.\n" +
                   "Kick the dumbbell up with your knee and rest the other end of the dumbbell on your shoulder.\n" +
                   "Adjust your grip so that your hands make a heart shape under the plate.\n" +
                   "Lift the dumbbell around your shoulder and hold it behind your back, with your upper arms vertical and elbows flexed.\n" +
                   "Execution\n" +
                   "Keeping your elbows close to your head and your upper arms vertical, exhale as you raise the dumbbell by extending your elbows.\n" +
                   "Inhale as you lower the dumbbell to the starting position by flexing your elbows.\n" +
                   "Repeat.", R.raw.tricep_sitting_dumbell_extensions);
               break;

           case 4: inserteerdata("TRICEPS", "dips", R.raw.tricep_dips, "Starting position\n" +
                   "Mount the should-width dip bars and straighten your arms so that your legs are suspended off the ground.\n" +
                   "Execution\n" +
                   "Keeping your elbows tucked in and your body upright, slowly lower your body until your elbows form a 90-degree angle or you feel a slight stretch in your shoulders. Don’t forget to inhale.\n" +
                   "Exhale as you push your body back up to the starting position.\n" +
                   "Repeat for the recommended number of repetitions.", R.raw.tricep_dips);
               break;

           case 5: inserteerdata("TRICEPS", "bench dips", R.raw.tricep_bench_dips, "Starting position\n" +
                   "Sit on the side of a bench and place your hands on the edge of the bench, by your hips.\n" +
                   "Move your feet forward a little and slide your bottom off the bench so that your body weight is supported by your arms and your knees are bent at 90-degree angles.\n" +
                   "Execution\n" +
                   "Keeping your torso upright and your elbows close to your body, inhale as you lower your body by flexing your elbows.\n" +
                   "Exhale as you raise your body by extending your elbows.\n" +
                   "Repeat.", R.raw.tricep_bench_dips);
               break;

           case 6: inserteerdata("TRICEPS", "skull crusher", R.raw.tricep_skull_crusher, "Starting position\n" +
                   "Lie on your back (supine) on a flat bench.\n" +
                   "Dismount the barbell using a pronated (overhand), shoulder-width grip and hold the barbell over your forehead so that your arms are slightly slanted backwards.\n" +
                   "Execution\n" +
                   "Keeping your upper arms still, inhale as you lower the barbell toward your forehead in a smooth, semicircular motion by flexing your elbows.\n" +
                   "Exhale as you reverse the movement and push the barbell back up to the starting position by extending your elbows.\n" +
                   "Repeat for the prescribed number of repetitions", R.raw.tricep_skull_crusher);
               break;

           case 7: inserteerdata("TRICEPS", "incline skull crushers", R.raw.tricep_incline_skull_crushers, "Starting position\n" +
                   "Holding a loaded EZ bar using a narrow pronated (overhand) grip, sit on a bench or a chair that supports your back.\n" +
                   "Press the EZ bar over your head.\n" +
                   "Execution\n" +
                   "Keeping your upper arms fixed and your elbows close to your head, inhale as you flex your elbows and lower the EZ bar behind your head in a semicircular motion.\n" +
                   "Exhale as you reverse the motion and push the EZ bar back over your head.\n" +
                   "Repeat.", R.raw.tricep_incline_skull_crushers);
               break;

           case 8: inserteerdata("TRICEPS", "close grip pushups", R.raw.tricep_close_grip_pushups, "Starting position\n" +
                   "Get on all fours with your hands positioned either directly under your shoulders or closer together.\n" +
                   "Extend your feet backward and straighten your body.\n" +
                   "Execution\n" +
                   "Keeping your body straight and your elbows tucked in, inhale as you lower your chest onto your hands.\n" +
                   "Exhale as you push your body back up to the starting position.\n" +
                   "Repeat.", R.raw.tricep_close_grip_pushups);
               break;

           case 9: inserteerdata("TRICEPS", "rop push down", R.raw.tricep_rop_push_down, "Starting position\n" +
                   "Stand under the cable pulley and grasp each end of the rope attachment with a neutral grip (palms facing each other).\n" +
                   "Pull your elbows down to your sides and lean forward a little at the hips, keeping your back straight.\n" +
                   "Execution\n" +
                   "Exhale as you extend your elbows and push the rope all the way down. As your arms extend, twist your wrists so that your palms face down at the end of the movement.\n" +
                   "Inhale as you reverse the motion and return the rope to the starting position.\n" +
                   "Repeat.", R.raw.tricep_rop_push_down);
               break;

           case 10: inserteerdata("TRICEPS", "single arm extension", R.raw.tricep_single_arm_extension, "Grab a dumbbell and either sit on a military press bench or a utility bench that has a back support on it as you place the dumbbells upright on top of your thighs or stand up straight.\n" +
                   "Clean the dumbbell up to bring it to shoulder height and then extend the arm over your head so that the whole arm is perpendicular to the floor and next to your head. The dumbbell should be on top of you. The other hand can be kept fully extended to the side, by the waist, supporting the upper arm that has the dumbbell or grabbing a fixed surface.\n" +
                   "Rotate the wrist so that the palm of your hand is facing forward and the pinkie is facing the ceiling. This will be your starting position.\n" +
                   "Slowly lower the dumbbell behind your head as you hold the upper arm stationary. Inhale as you perform this movement and pause when your triceps are fully stretched.\n" +
                   "Return to the starting position by flexing your triceps as you breathe out. Tip: It is imperative that only the forearm moves. The upper arm should remain at all times stationary next to your head.\n" +
                   "Repeat for the recommended amount of repetitions and switch arms.", R.raw.tricep_single_arm_extension);
               break;

           case 11: inserteerdata("TRICEPS", "cable kickback",R.raw.tricep_cable_kickback, "Starting position\n" +
                   "Set up a hip-high cable pulley.\n" +
                   "Remove the stirrup/handle or bar so that there is no attachment.\n" +
                   "Grasp the clip at the end of the cable and step back until the cable is pulled taut.\n" +
                   "Lean forward a little and raise your upper arm so that it is parallel with the floor.\n" +
                   "Execution\n" +
                   "Keeping your upper arm fixed, exhale as you extend your elbow until it is fully extended.\n" +
                   "Hold for a count of two.\n" +
                   "Inhale as you flex your elbow and return the cable to the starting position.\n" +
                   "Repeat for more repetitions.\n" +
                   "Repeat the repetitions with your opposite arm.",R.raw.tricep_cable_kickback);
               break;

           case 12:inserteerdata("BICEPS", "Dumbbell One Arm Reverse Preacher Curl",R.raw.biceps_dumbbell_one_arm_reverse_preacher_curl, "Starting position\n" +
                   "Sit on the preacher bench with a dumbbell in your hand.\n" +
                   "Supinate your forearm (turn your palm upward), bend your elbow so that the dumbbell faces your shoulder, and rest your upper arm flat on the bench.\n" +
                   "Execution\n" +
                   "Inhale as you lower the dumbbell until your arm is almost fully extended.\n" +
                   "Exhale as you curl the dumbbell to the starting position.\n" +
                   "Repeat for the desired number of repetitions.\n" +
                   "Repeat with your opposite arm.",R.raw.biceps_dumbbell_one_arm_reverse_preacher_curl);
               break;

           case 13: inserteerdata("BICEPS", "dumbbell curls",R.raw.biceps_dumbbell_curls, "Starting position\n" +
                   "Stand holding a pair of dumbbells by your sides using a neutral grip (palms facing in).\n" +
                   "Pull your shoulders back.\n" +
                   "Execution\n" +
                   "Exhale as you slowly curl one dumbbell up towards your shoulder. As the dumbbell rises, supinate your forearm gradually so that your palm faces your shoulder by the top of the curl.\n" +
                   "Once your elbow is fully flexed, allow your elbow to move forward a little (shoulder flexion), just until your forearm is vertical.\n" +
                   "Hold for a count of two and squeeze your biceps.\n" +
                   "Inhale as you slowly reverse the movement at half the speed and return the dumbbell to the starting position.\n" +
                   "Repeat the same action with the opposite arm, and then alternate repetitions.", R.raw.biceps_dumbbell_curls);
               break;

           case 14: inserteerdata("BICEPS", "reverse curls",R.raw.biceps_reverse_curls , "Starting position\n" +
                   "Stand with a dumbbell in each hand.\n" +
                   "Pronate your wrists into a shoulder-width reverse (overhand) grip.\n" +
                   "Execution\n" +
                   "Keeping your elbows by your sides, exhale as you curl the dumbbells toward your shoulders until your forearms are nearly vertical.\n" +
                   "Hold for a count of two and squeeze your biceps.\n" +
                   "Inhale as you return the dumbbells to the starting position.\n" +
                   "Repeat.", R.raw.biceps_reverse_curls);
               break;

           case 15: inserteerdata("BICEPS", "biceps Barbell Close grip Curl", R.raw.biceps_barbell_close_grip_curl, "Starting position\n" +
                   "Stand holding an EZ-curl bar using a close supinated grip (hands closer than shoulder width apart and palms facing upward). Your elbows should be almost fully extended, and the bar should be resting against your thighs.\n" +
                   "Execution\n" +
                   "Keeping your elbows fixed to your sides, exhale as you curl the EZ-curl bar up toward your shoulders.\n" +
                   "Hold for a count of two and squeeze your biceps.\n" +
                   "Inhale as you lower the EZ-curl bar to the starting position.\n" +
                   "Repeat for the prescribed number of repetitions.", R.raw.biceps_barbell_close_grip_curl);
               break;

           case 16: inserteerdata("BICEPS", "lats pull downs", R.raw.biceps_dumbbell_peacher_hammer_curl, "Starting position\n" +
                   "Holding a pair of dumbbells, sit on the preacher bench.\n" +
                   "Keeping your elbows flexed and your palms facing each other (neutral or hammer grip), place the backs of your upper arms flat on the arm rest.\n" +
                   "Execution\n" +
                   "Inhale as you lower the dumbbells until your elbows are almost fully extended.\n" +
                   "Exhale as you curl the dumbbells back up toward your shoulders.\n" +
                   "Hold for a count of two at the top of the movement and squeeze your biceps.\n" +
                   "Repeat.", R.raw.biceps_dumbbell_peacher_hammer_curl);
               break;

           case 17: inserteerdata("BICEPS", "Barbell Standing Reverse Grip Curl rows", R.raw.biceps_barbell_standing_reverse_grip_curl, "Starting position\n" +
                   "Stand holding a barbell using a shoulder-width pronated (overhand) grip.\n" +
                   "Execution\n" +
                   "Keeping your elbows by your sides, exhale as you curl the barbell up until your forearms are nearly vertical.\n" +
                   "Inhale as you lower the barbell back to the starting position in a controlled manner.\n" +
                   "Repeat.", R.raw.biceps_barbell_standing_reverse_grip_curl);
               break;

           case 18: inserteerdata("BICEPS", "Cable Curl", R.raw.biceps_cable_curl, "Starting position\n" +
                   "Attach a bar to a low cable pulley.\n" +
                   "Grasp the bar using a shoulder-width supinated (underhand) grip.\n" +
                   "Stand approximately one foot away from the pulley and lean backward a little. Your elbows should be by your sides, your arms should be almost fully extended, and the cable should be pulled taut.\n" +
                   "Execution\n" +
                   "Keeping your body still, exhale as you curl the bar towards your shoulders until your elbows are fully flexed.\n" +
                   "Once your elbows are fully flexed, allow them to move forward a little (shoulder flexion), just until your forearms are vertical.\n" +
                   "Hold for a count of two and squeeze your biceps.\n" +
                   "Inhale as you lower the bar to the starting position, with your elbows by your sides and arms almost fully extended.\n" +
                   "Repeat.", R.raw.biceps_cable_curl);
               break;

           case 19: inserteerdata("BICEPS", "Dumbbell reverse curls", R.raw.biceps_dumbbell_reverse_curls, "Starting position\n" +
                   "Stand with a dumbbell in each hand.\n" +
                   "Pronate your wrists into a shoulder-width reverse (overhand) grip.\n" +
                   "Execution\n" +
                   "Keeping your elbows by your sides, exhale as you curl the dumbbells toward your shoulders until your forearms are nearly vertical.\n" +
                   "Hold for a count of two and squeeze your biceps.\n" +
                   "Inhale as you return the dumbbells to the starting position.\n" +
                   "Repeat.", R.raw.biceps_dumbbell_reverse_curls);
               break;

           case 20: inserteerdata("CHEST", "incline bench press rod", R.raw.chest_incline_bench_press_rod, "Starting position\n" +
                   "\n" +
                   "Lie supine (on your back) on a bench inclined at 45 degrees.\n" +
                   "Spread your legs, bring your feet back, and place them firmly on the ground.\n" +
                   "Arch your back.\n" +
                   "Dismount the barbell using a wider-than-shoulder-width grip.\n" +
                   "Retract (push together) your shoulder blades and straighten your wrists.\n" +
                   "Execution\n" +
                   "\n" +
                   "Inhale as you lower the barbell to your chest, keeping your elbows tucked in.\n" +
                   "Exhale as you press the barbell back up to the starting position.\n" +
                   "Repeat.", R.raw.chest_incline_bench_press_rod);
               break;

           case 21: inserteerdata("CHEST", "bench press rod", R.raw.chest_bench_press_rod, "Starting position\n" +
                   "\n" +
                   "Lock your feet under the leg brace of a declined bench and lie on your back.\n" +
                   "Using a grip that is a little wider than shoulder width, dismount the barbell from the rack.\n" +
                   "While holding the barbell, retract your shoulder blades (push them together) and straighten your wrists.\n" +
                   "Execution\n" +
                   "\n" +
                   "Keeping your elbows tucked in a little, inhale as you lower the barbell to your chest.\n" +
                   "Exhale as you press the barbell back up to the starting position.\n" +
                   "Repeat.", R.raw.chest_bench_press_rod);
               break;

           case 22: inserteerdata("CHEST", "decline bench press_rod",R.raw.chest_decline_bench_press_rod, "Starting position\n" +
                   "\n" +
                   "Lock your feet under the leg brace of a declined bench and lie on your back.\n" +
                   "Using a grip that is a little wider than shoulder width, dismount the barbell from the rack.\n" +
                   "While holding the barbell, retract your shoulder blades (push them together) and straighten your wrists.\n" +
                   "Execution\n" +
                   "\n" +
                   "Keeping your elbows tucked in a little, inhale as you lower the barbell to your chest.\n" +
                   "Exhale as you press the barbell back up to the starting position.\n" +
                   "Repeat.",R.raw.chest_decline_bench_press_rod);
               break;

           case 23: inserteerdata("CHEST", "weighted pushups",R.raw.chest_weighted_pushups, "Starting position\n" +
                   "With a dumbbell in each hand, sit on a decline bench, rest the dumbbells on your knees, and hook your feet under the foot pads. (Or have a spotter hand you the dumbbells after you sit down and hook your feet.)\n" +
                   "Lie back on the bench and, as you do so, raise the dumbbells over your upper abdomen.\n" +
                   "Flex your elbows a little, and internally rotate your shoulders so that your elbows point out to the sides.\n" +
                   "Execution\n" +
                   "Inhale as you slowly lower the dumbbells in a semicircular motion to your sides until you feel a slight stretch in your chest.\n" +
                   "Exhale as you reverse the motion and bring the dumbbells back up over your chest in a hugging movement.\n" +
                   "Repeat for the prescribed number of repetitions.",R.raw.chest_decline_bench_fly);
               break;

           case 24: inserteerdata("BACK", "bent over rows",R.raw.back_bent_overows, "Starting position\n" +
                   "\n" +
                   "Holding a dumbbell in your left hand, kneel on a bench with your right knee and support your body with your right arm. The dumbbell should be hanging straight down, with your left arm almost fully extended.\n" +
                   "Execution\n" +
                   "\n" +
                   "Exhale as you pull the dumbbell up to the side of your waist.\n" +
                   "Hold for a count of two.\n" +
                   "Inhale as you lower the dumbbell to the starting position.\n" +
                   "Repeat for the desired number of reps.\n" +
                   "Repeat with your right arm.",R.raw.back_bent_overows);
               break;

           case 25: inserteerdata("CHEST", "high fly standing", R.raw.chest_high_fly_standing, "Step 1: Place the cable fly handles on the highest notches.\n" +
                   "Step 2: Take a handle in each hand.\n" +
                   "Step 3: Step out with your right foot forward so that your feet are in a staggered stance.\n" +
                   "Step 4: With your elbows slightly bent pull the handles forward and together meeting in the center of your chest.\n" +
                   "Step 5: Bring your hands back to starting position. This completes one repetition.", R.raw.chest_high_fly_standing);
               break;

           case 26: inserteerdata("CHEST", "cable cross", R.raw.chest_cable_cross, "Attach two single grip handles to the cable machine at about chest level.\n" +
                   "Then, grab both handles and step forward so your arms are behind you and until you feel a slight stretch in your chest. Position one foot forward and one behind. Keep your elbows bent.\n" +
                   "Now, pull both cables together in a semicircular motion until they almost touch each other. Contract your chest muscles exhale during this portion of the exercise.\n" +
                   "Hold for a couple of seconds.\n" +
                   "Then, slowly allow your arms to return to the starting position until you feel a slight stretch in your chest muscles. Inhale during this portion of the exercise.\n" +
                   "Repeat for the desired number of reps.", R.raw.chest_cable_cross);
               break;
               //
           case 27: inserteerdata("CHEST", "bench press dumbells", R.raw.chest_bench_press_dumbells, "Starting position\n" +
                   "\n" +
                   "Holding a dumbbell in each hand, sit on a flat bench and rest one dumbbell on each knee.\n" +
                   "As you lie back on the bench, kick each dumbbell up into position, one at a time.\n" +
                   "Position the dumbbells to the sides of your chest, with your arms bent at a 90-degree angle. Your elbows should not be pointing straight out to the sides; rather, tuck them in a little to approximately a 45-degree angle.\n" +
                   "Spread your legs, bring your feet back, and place them firmly on the ground. Either your toes or your heels should be planted firmly on the floor.\n" +
                   "Arch your back and straighten your wrists.\n" +
                   "Execution\n" +
                   "\n" +
                   "Exhale as you slowly press the dumbbells upward and inward until your arms are almost fully extended and the dumbbells nearly touch.\n" +
                   "Inhale as you slowly lower the dumbbells back to the starting position, or until you feel a slight stretch in your chest.\n" +
                   "Repeat.", R.raw.chest_bench_press_dumbells);
               break;

           case 28: inserteerdata("CHEST", "machine fly", R.raw.chest_machine_fly, "Starting position\n" +
                   "Sit on the fly machine with your back pressed firmly against the back support.\n" +
                   "Grasp the levers at shoulder height.\n" +
                   "Internally rotate your shoulders so that your wrists, elbows, and shoulders are level.\n" +
                   "Execution\n" +
                   "Keeping your elbows slightly bent, exhale as you push the levers together.\n" +
                   "Inhale as you reverse the motion until you feel a mild stretch in your chest or shoulders.\n" +
                   "Repeat.", R.raw.chest_machine_fly);
               break;

           case 29: inserteerdata("CHEST", "incline fly", R.raw.chest_incline_fly, "Starting position\n" +
                   "Holding a dumbbell in each hand, sit on a bench inclined at 45 degrees and rest each dumbbell on a knee.\n" +
                   "Lie backward, and as you do so, kick the dumbbells up into position over your chest, one at a time.\n" +
                   "Spread your legs and plant your feet flat on the floor.\n" +
                   "Flex your elbows slightly, and internally rotate your shoulders so that your elbows point out to the sides.\n" +
                   "Execution\n" +
                   "Keeping your elbows locked, inhale as you lower the dumbbells to your sides in an arcing motion until you feel a mild stretch in your chest or shoulders.\n" +
                   "Exhale as you reverse the motion and press the dumbbells back up to the starting position.\n" +
                   "Repeat for the prescribed number of repetitions.", R.raw.chest_incline_fly);
               break;

           case 30: inserteerdata("SHOULDER", "cable standing rear delt row with rope", R.raw.shoulder_cable_standing_rear_delt_row_with_rope, "Stand with the feet hip-width apart, the hips straight, the back tall,.\n" +
                   " and the knees slightly bent.\n" +
                   " Place the cable pulley at about shoulder-height, attach a rope handle, and hold one end of the rope in each hand with the palms facing down.\n" +
                   " Turn to face the machine. Lift the chest up and pull the elbows back until the hands are right in front of the shoulders,\n" +
                   " then pause for 2-3 seconds. Slowly straighten the arms to return the weight to the starting position.\n", R.raw.shoulder_cable_standing_rear_delt_row_with_rope);
               break;

           case 31: inserteerdata("SHOULDER", "press dumbells",R.raw.sholuder_shoulder_press_dumbells, "Starting position\n" +
                   "Holding a pair of dumbbells, sit up straight on a bench or chair, preferably one that supports your back.\n" +
                   "Raise the dumbbells one at a time to each side, and hold them at shoulder height, with your palms facing forward.\n" +
                   "Execution\n" +
                   "Exhale as you press the dumbbells upward and inward until they almost touch over your head.\n" +
                   "At the top of the movement, shrug your shoulders to raise the dumbbells even higher.\n" +
                   "Inhale as you reverse the motions and lower the dumbbells to the starting position.\n" +
                   "Repeat.", R.raw.sholuder_shoulder_press_dumbells);
               break;

           case 32: inserteerdata("SHOULDER", " plate front raises", R.raw.shoulder_plate_front_raises, "Starting position\n" +
                   "Set the height of the bar of the Smith machine so that it’s just above knee height.\n" +
                   "Set the safety pins to prevent the bar from being able to drop and potentially damage your legs.\n" +
                   "Stand in front of the bar and grasp it using a shoulder-width pronated grip (palms facing your body).\n" +
                   "Unlatch the bar from the rail by rotating it, and stand up straight.\n" +
                   "Execution\n" +
                   "Keeping your elbows slightly flexed, exhale as you elevate your shoulders as high as possible.\n" +
                   "Hold for a count of two and squeeze your trapezius.\n" +
                   "Inhale as you lower the bar back to the starting position.\n" +
                   "Repeat for the prescribed number of repetitions.\n" +
                   "After you have finished, latch the bar back onto the rail by rotating it.", R.raw.shoulder_plate_front_raises);
               break;
           case 33: inserteerdata("SHOULDER", "plate front raises", R.raw.shoulder_plate_front_raises, "Starting position\n" +
                   "Stand up straight, holding a weight plate in front of your thighs with both hands. Your hands should be at the three and nine o’clock positions.\n" +
                   "Execution\n" +
                   "Keeping your back straight and your elbows slightly bent, exhale as you raise the plate out in front of you in an arcing motion until your arms are parallel with the floor.\n" +
                   "Hold for a count of two.\n" +
                   "Inhale as you lower the plate in a controlled manner to the starting position.\n" +
                   "Repeat.", R.raw.shoulder_plate_front_raises);
               break;
           case 34: inserteerdata("SHOULDER", "upright rows", R.raw.shoulder_upright, "Starting position\n" +
                   "Stand upright holding a barbell with a shoulder-width, overhand (pronated) grip. The bar should be resting on the front of your thighs.\n" +
                   "Pull your shoulders back and stick your chest out.\n" +
                   "Execution\n" +
                   "Exhale as you pull the bar up towards your chin, making sure to stop when the bar is level with your lower or middle chest. Do not pull the bar any higher.\n" +
                   "Hold for a count of two.\n" +
                   "Inhale as you lower the bar to the starting position.\n" +
                   "Repeat for the recommended number of repetitions.", R.raw.shoulder_upright);
               break;
           case 35: inserteerdata("SHOULDER", "lateral raise single arm", R.raw.shoulder_lateral_raise_single_arm, "Starting position\n" +
                   "Holding a dumbbell in one hand, flex your hips and knees until your torso is parallel to the floor.\n" +
                   "For stability, grasp something stable with your free hand. Your back should be straight and the arm with the dumbbell should be hanging straight down in front of you, with your palm facing inward (neutral grip).\n" +
                   "Execution\n" +
                   "Keeping your elbow slightly flexed, exhale as you raise the dumbbell directly out to the side until it is level with the height of your shoulder.\n" +
                   "Hold for a count of two.\n" +
                   "Inhale as you lower the dumbbell to the starting position in a controlled manner.\n" +
                   "Repeat for the prescribed number of repetitions.\n" +
                   "Repeat the exercise with your opposite arm.", R.raw.shoulder_lateral_raise_single_arm);
               break;
           case 36: inserteerdata("SHOULDER", "shoulder front raises", R.raw.shoulder_front_raises, "Starting position\n" +
                   "Stand holding a dumbbell in each hand, with your elbows slightly bent and the dumbbells resting on the front of your thighs.\n" +
                   "Execution\n" +
                   "Keeping your elbow slightly bent, exhale as you raise your right arm in front of you until it is at least parallel to the floor.\n" +
                   "Hold for a count of two.\n" +
                   "Inhale as you lower your right arm to the starting position.\n" +
                   "Repeat with your left arm.\n" +
                   "Keep alternating your arms, raising one after the other one has been fully lowered.", R.raw.shoulder_front_raises);
               break;
           case 37: inserteerdata("SHOULDER", "lateral raise both arms",R.raw.shoulder_lateral_raise_both_arms, "Starting position\n" +
                   "\n" +
                   "Note: The procedure described below is different from the illustration and adheres to the procedure explained in the video.\n" +
                   "\n" +
                   "Stand holding a dumbbell in each hand, with the dumbbells hanging down by your sides.\n" +
                   "Bend forward a little at the hips.\n" +
                   "Eternally rotate your shoulders so that your thumbs point out diagonally.\n" +
                   "Execution\n" +
                   "Keeping your elbows slightly bent, exhale as you raise both upper arms out to the sides until your elbows are level with your shoulders.\n" +
                   "Hold for a count of two.\n" +
                   "Inhale as you lower the dumbbells to the starting position.\n" +
                   "Repeat for the recommended number of repetitions.",R.raw.shoulder_lateral_raise_both_arms);
               break;
           case 38: inserteerdata("SHOULDER", "double cable front raise", R.raw.shoulder_double_cable_front_raise, "Starting position\n" +
                   "Attach stirrups (handles) to two low cable pulleys.\n" +
                   "Grasp one stirrup in each hand and stand midway between the two pulleys.\n" +
                   "Step forward until the cables are pulled taut and your arms are left a little behind you.\n" +
                   "Execution\n" +
                   "Keeping your elbows very slightly flexed, exhale as you raise the stirrups forward and upward in a semicircular motion until your arms are a little above horizontal.\n" +
                   "Hold for a count of two.\n" +
                   "Inhale as you lower the stirrups to the starting position in a controlled manner.\n" +
                   "Repeat.", R.raw.shoulder_double_cable_front_raise);
                break;
           case 39: inserteerdata("SHOULDER", "one arm rear lateral raise", R.raw.shoulder_one_arm_rear_lateral_raise, "Starting position\n" +
                   "Holding a dumbbell in one hand, lie prone (on your front) on a flat bench. Ideally, the bench should be elevated to allow the dumbbell to hang straight down without touching the floor.\n" +
                   "Spread your legs and plant your feet firmly on the floor.\n" +
                   "Grasp the bench with your free hand for stability.\n" +
                   "Execution\n" +
                   "Keeping your elbow slightly bent, exhale as you raise the dumbbell out to the side.\n" +
                   "Hold for a count of two.\n" +
                   "Inhale as you lower the dumbbell to the starting position in a controlled manner.\n" +
                   "Repeat for the desired number of repetitions.\n" +
                   "Repeat the exercise with your opposite arm.\n", R.raw.shoulder_one_arm_rear_lateral_raise);
               break;

           case 40: inserteerdata("SHOULDER", "barbell overhead press", R.raw.shoulder_barbell_overhead_press, "Starting position\n" +
                   "Sit up straight on a bench, holding a barbell at chest height with a pronated (overhand) grip. Your hands should be a little wider than shoulder width apart.\n" +
                   "\n" +
                   "Execution\n" +
                   "Exhale as you push the barbell straight upward.\n" +
                   "At the top of the movement, shrug your shoulders to raise the barbell even higher.\n" +
                   "Inhale as you reverse the motions and lower the barbell to the starting position in a controlled manner.\n" +
                   "Repeat.", R.raw.shoulder_barbell_overhead_press);
               break;

           case 41: inserteerdata("SHOULDER", "ez barbell overhead press", R.raw.shoulder_ez_barbell_overhead_press, "Starting position\n" +
                   "Stand with your feet shoulder-width apart, holding a barbell with a pronated (overhand) grip at upper-chest height.\n" +
                   "Execution\n" +
                   "Exhale as you push the barbell straight upward.\n" +
                   "At the top of the movement, shrug your shoulders to raise the barbell even higher.\n" +
                   "Inhale as you reverse the motions and lower the barbell to the starting position in a controlled manner.\n" +
                   "Repeat.", R.raw.shoulder_ez_barbell_overhead_press);
               break;

           case 42: inserteerdata("SHOULDER", "arnold press standing",R.raw.shoulder_arnold_press_standing, "Starting position\n" +
                   "Stand with a dumbbell in each hand.\n" +
                   "Raise the dumbbells to the height of your chin, with your elbows pointing diagonally out to the sides and your pinkie fingers raised higher than your thumbs.\n" +
                   "Execution\n" +
                   "Exhale as you swing your elbows backward and a little upward as you move your head and torso forward. At the top of the movement, the pinkie sides of your fists should be facing almost directly upward.\n" +
                   "Inhale as you reverse the movement and return to the starting position.\n" +
                   "Repeat for the prescribed number of repetitions.",R.raw.shoulder_arnold_press_standing);
               break;

           case 43: inserteerdata("BACK", "Lats pulldown", R.raw.back_lats_pulldown, "1.Start by sitting at a lat pull machine, facing the bar. Adjust the knee pad so your knees are bent at 90 degrees and firmly under the pad and your feet are flat on the floor.\n" +
                   "2.Reach up and grasp the bar a little wider than shoulder width. Extend your arms as much as you can without shrugging your shoulders or lifting off the seat.\n" +
                   "3.Pull the bar down toward your upper chest, aiming for just below your collarbone. Think of pulling your elbows and shoulder blades down and back as you bring the bar down. Keep your body tall and in a slight backward lean, just past vertical at 70–80 degrees.\n" +
                   "4.Hold the bar at your mid to upper chest for 1–2 seconds while squeezing your shoulder blades back and down.\n" +
                   "5.Slowly return to the starting position. Remember not to shrug your shoulders at the top of the movement.\n" +
                   "6.Complete 2–3 sets of 8–10 reps.", R.raw.back_lats_pulldown);
               break;

           case 44: inserteerdata("BACK", "superman strech",R.raw.back_superman, "Starting position\n" +
                   "\n" +
                   "Lie prone (face down) on a mat with your legs straight and your arms extended straight in front of you.\n" +
                   "Execution\n" +
                   "\n" +
                   "Gently raise your arms, upper torso, and legs off the mat.\n" +
                   "Hold for a count of two.\n" +
                   "Gently return them to the starting position.\n" +
                   "Repeat.",R.raw.back_superman);
               break;

           case 45: inserteerdata("BACK", "kneeling one arm pulldown", R.raw.back_kneeling_one_arm_pulldown, "Select an appropriate weight and adjust the knee pad to help keep you down. Grasp the handle with a pronated grip. This will be your starting position.\n" +
                   "Pull the handle down, squeezing your elbow to your side as you flex the elbow.\n" +
                   "Pause at the bottom of the motion, and then slowly return the handle to the starting position.\n" +
                   "For multiple repetitions, avoid completely returning the weight to keep tension on the muscles being worked.\n", R.raw.back_kneeling_one_arm_pulldown);
               break;


           case 46: inserteerdata("BACK", "barbell bent overows", R.raw.back_barbell_bent_overows, "Stand behind a barbell with your feet shoulder-width apart.\n" +
                   "Bend at the hips while keeping the back straight and knees slightly bent. Think of sitting back slightly (moving your tailbone behind your feet) — this helps with positioning for lifting the barbell. Your body should be bent forward at about a 45 degree angle, but no further.\n" +
                   "Grasp the bar a little wider than shoulder width, keeping your forearms pronated (palms facing your shins).\n" +
                   "Tighten your glutes and core as you pull your elbows up behind you, bringing the bar to your abs. Keep pulling your elbows behind you and squeeze your shoulder blades together while keeping your back straight.\n" +
                   "Hold for 1 second and then slowly lower the bar back to the starting position, with your arms extended and the barbell plates just off the ground", R.raw.back_barbell_bent_overows);
               break;

           case 47: inserteerdata("BACK", "pull ups",R.raw.back_pull_ups, "Starting position\n" +
                   "Grasp the bar with a wider-than-shoulder-width pronated (overhand) grip.\n" +
                   "Hang with your arms and shoulders fully stretched.\n" +
                   "Execution\n" +
                   "Exhale as you pull your body up until your chin rises above the bar.\n" +
                   "Hold for a count of two and squeeze your back muscles.\n" +
                   "Inhale as you lower your body until your arms and shoulders are fully stretched.\n" +
                   "Repeat.",R.raw.back_pull_ups);
               break;

           case 48: inserteerdata("BACK", "back cablerow", R.raw.back_cablerow, "Starting position\n" +
                   "Sit facing the cable row machine and place your feet on the foot rests.\n" +
                   "Grasp the double-row bar and slide your bottom backward until your knees are almost straight. You torso should be leaning forward and your arms and shoulders should be stretching forward.\n" +
                   "Execution\n" +
                   "Exhale as you slowly lean backward, straighten your back, and pull the v-bar to your abdomen, keeping your elbows close to your body. Pull your shoulders back and stick out your chest at the top of the movement.\n" +
                   "Hold for a count of two and squeeze your back muscles.\n" +
                   "Inhale as you slowly lean forward and return the double-row bar to the starting position, with your arms and shoulders stretching forward and your lower back bent forward.\n" +
                   "Repeat for the recommended number of repetitions.", R.raw.back_cablerow);
               break;

           case 49: inserteerdata("BACK", "bent overows dumbells", R.raw.back_bent_overows_dumbells, "Starting position\n" +
                   "\n" +
                   "Holding a dumbbell in each hand using a neutral (hammer) grip, stand with your feet shoulder-width apart.\n" +
                   "Keeping a natural curvature of your spine, flex your hips and knees until your torso is horizontal or close to horizontal.\n" +
                   "Allow the dumbbells to hang down by your sides, with your shoulders stretching downward.\n" +
                   "Execution\n" +
                   "\n" +
                   "Keeping your elbows close to your body, exhale as you pull the dumbbells up to the sides of your waist.\n" +
                   "Hold for a count of two and squeeze your back muscles.\n" +
                   "Inhale as you lower the dumbbells to the starting position, with your shoulders stretching downward.\n" +
                   "Repeat.\n", R.raw.back_bent_overows_dumbells);
               break;

           case 50: inserteerdata("BACK", "t-bar lever bent over row",R.raw.back_t_bar_lever_bent_over_row, "Starting position\n" +
                   "\n" +
                   "Stand with a loaded landmine between your legs.\n" +
                   "Bend at the hips and a little at the knees and grasp the landmine bar just under the plates with both hands. You can either interlink your fingers or place one hand over the other. Instead of grasping the landmine bar, you can also hook a double-row bar around it. Your back should be straight and close to horizontal.\n" +
                   "Execution\n" +
                   "\n" +
                   "Keeping your elbows close to your body, exhale as you pull the landmine to your chest.\n" +
                   "Hold for a count of two and squeeze your back muscles.\n" +
                   "Inhale as you lower the landmine in a controlled manner until your shoulders stretch downward. Don’t allow the landmine to touch the floor.\n" +
                   "Repeat.",R.raw.back_t_bar_lever_bent_over_row);
               break;

           case 51: inserteerdata("BACK", "underhand yates rows", R.raw.back_underhand_yates_rows, "Starting position\n" +
                   "\n" +
                   "Holding a barbell using a shoulder-width supinated (underhand) grip, stand with your feet hip-width apart.\n" +
                   "Flex your hips and knees to lean forward at a 45-degree angle. Your arms should be almost fully extended and the barbell should be resting on your thighs.\n" +
                   "Execution\n" +
                   "\n" +
                   "Keeping your head up and your back straight, exhale as you pull the barbell up to your waist.\n" +
                   "Hold for a count of two and squeeze your back muscles.\n" +
                   "Inhale as you lower the barbell to the starting position in a controlled manner.\n" +
                   "Repeat.", R.raw.back_underhand_yates_rows);
               break;


           case 52: inserteerdata("LEGS", "bodyweight squarts", R.raw.legs_bodyweight_squarts, "1. Stand with your feet shoulder-width apart and your toes pointed forward." +
                   " (As you move through the exercise, be mindful that your knees never go forward past your toes.)\n" +
                   "\n" +

                   "2. Keep your chest up and make sure not to tilt your head down. Pull your navel in toward your spine to engage your core.\n" +
                   "\n" +
                   "3. Bend at the hips and knees while keeping your heels and toes on the floor.\n" +
                   "\n" +
                   "4. Slowly sit back into a squat position with your chest up, your shoulders back and abs in. Make sure that your knees are not crossing over your toes, and that you are as close to a 90-degree angle as possible.\n" +
                   "\n" +
                   "5. Straighten your legs by pressing into your heels to stand back up. Squeeze your glutes at the top, tilting your pelvis forward.", R.raw.legs_bodyweight_squarts);
               break;

           case 53: inserteerdata("LEGS", "stability ball wall squat",R.raw.legs_stability_ball_wall_squat, "Stand with your feet hip-width apart and a stability ball between the middle of your back and a wall. Your feet should be slightly in front of your body. This is your starting position.\n" +
                   "Bend your knees to roll your body down the ball until your thighs are parallel to the floor. Your knees should be in line with your middle toes\n" +
                   "Pause, then press through your heels to return to starting position and repeat.\n" +
                   "Make this move harder by holding a dumbbell in each hand.",R.raw.legs_stability_ball_wall_squat);
               break;

           case 54: inserteerdata("LEGS", "barbell squarts", R.raw.legs_barbell_squrats, "Set up in a rack with your feet about shoulder-width apart, and the bar resting across your upper back on the fleshy muscle around your neck. Grab the bar with an overhand grip (palms facing forward).\n" +
                   "Unrack the bar carefully and set your feet at a comfortable stance. Your feet can be slightly turned out or facing straight ahead. If you don’t know where you’re comfortable, play with your foot placement.\n" +
                   "Brace your core and upper back. Maintain a tight torso throughout the movement with a small, natural arch in your low back.\n" +
                   "Keeping your weight in your heels, push your hips back and bend your knees to lower as far as comfortable or until your thighs are parallel to the floor.\n" +
                   "Press your heels into the ground to stand back up", R.raw.legs_barbell_squrats);
               break;

           case 55: inserteerdata("LEGS", "dummbell deadlift", R.raw.legs_dummbell_deadlift, "Starting position\n" +
                   "Position a pair of dumbbells horizontally in front of your feet.\n" +
                   "Squat and grasp the dumbbells using a pronated (overhand) grip.\n" +
                   "Raise your hips a little, straighten your back, and lean backward so that your torso is upright.\n" +
                   "Execution\n" +
                   "Exhale as you stand up and pull the dumbbells up across the front of your body.\n" +
                   "Inhale as you push your butt backward, flex your hips and knees, and lower the dumbbells down the front of your body to the floor.\n" +
                   "Repeat.", R.raw.legs_dummbell_deadlift);
               break;

           case 56: inserteerdata("LEGS", "legs zercher squat",R.raw.legs_zercher_squat, "Starting position\n" +
                   "Place a barbell on a waist-high rack and load it.\n" +
                   "Keeping your elbows tucked in to your sides, scoop the barbell up with the crooks of your elbows, pull it into your body, and cross your wrists over the bar to hold it in place.\n" +
                   "Carefully step backward from the rack and stand with a wide stance, with your knees and feet pointing out diagonally in the same direction.\n" +
                   "Execution\n" +
                   "Keeping your back straight and body upright, inhale as you squat down until the bar touches your thighs.\n" +
                   "Exhale as you stand back up into the starting position, driving through your heels.\n" +
                   "Repeat.",R.raw.legs_zercher_squat);
               break;

           case 57: inserteerdata("LEGS", "front squat", R.raw.legs_front_squat, "Starting position\n" +
                   "Load a barbell on a rack at upper-chest height.\n" +
                   "Step under the barbell so that it rests on the front of your shoulders and place your fingers under the barbell, with your elbows pointing forward (if you do not have the flexibility to place your fingers under the barbell, you can cross your arms and place your hands on top of the barbell).\n" +
                   "Dismount the barbell and step backward carefully. Your feet should be shoulder-width apart and pointing slightly outward.\n" +
                   "Execution\n" +
                   "Inhale as you squat down by simultaneously pushing your butt backward and bending your knees forward. Keep your torso upright, and descend at least until your knees are bent at a 90-degree angle.\n" +
                   "Exhale as you push your body back up to the starting position, driving through your heels and keeping your torso upright.\n" +
                   "Repeat.", R.raw.legs_front_squat);
               break;


           case 58: inserteerdata("LEGS", "barbell bulgarian spilt squat", R.raw.legs_barbell_bulgarian_spilt_squat, "Starting position\n" +
                   "Place a barbell on the back of your shoulders and grasp it firmly at both sides.\n" +
                   "Stand with your back facing the side of a bench.\n" +
                   "Place the top of one foot on the bench behind you so that only one of your feet is making contact with the floor.\n" +
                   "Execution\n" +
                   "Keeping your torso upright, inhale as you squat down with your supporting leg until the knee of your back leg nearly touches the floor.\n" +
                   "Exhale as you push yourself back up to the starting position.\n" +
                   "Repeat for the desired number of repetitions.\n" +
                   "Repeat the repetitions with your opposite leg.", R.raw.legs_barbell_bulgarian_spilt_squat);
               break;

           case 59: inserteerdata("LEGS", "barbell lateral lunges",R.raw.legs_barbell_lateral_lunges, "Starting position\n" +
                   "Place a barbell on the back of your shoulders. You can either dismount the barbell from a high rack or clean it from the floor.\n" +
                   "Execution\n" +
                   "Keeping your body upright, inhale as you take a large step (lunge) to one side and lower your body by flexing your hip and knee. Keep your back leg straight.\n" +
                   "Exhale as you push yourself back up to the starting position.\n" +
                   "Repeat the lunge with your opposite leg.\n" +
                   "Keep repeating the lunge and alternating the leg with which you lead.",R.raw.legs_barbell_lateral_lunges);
               break;

           case 60: inserteerdata("LEGS", "cable hip aduction", R.raw.legs_cable_hip_aduction, "Starting position\n" +
                   "Attach an ankle strap to one ankle and hook it up to a low cable pulley.\n" +
                   "Stand perpendicular to the pulley with your strapped ankle farthest away from the pulley.\n" +
                   "Step away from the pulley so that the cable is pulled taut and your strapped leg is pulled across your unstrapped leg.\n" +
                   "Grasp something for stability and place your free hand on your hip.\n" +
                   "Execution\n" +
                   "Keeping both legs straight, exhale as you pull your strapped ankle away from the pulley until it is fully abducted.\n" +
                   "Hold for a count of two.\n" +
                   "Inhale as you slowly return your strapped leg to the starting position.\n" +
                   "Repeat for more repetitions.\n" +
                   "Repeat with your opposite ankle.", R.raw.legs_cable_hip_aduction);
               break;

           case 61: inserteerdata("LEGS", "trap bar deadlift", R.raw.legs_trap_bar_deadlift, "Starting position\n" +
                   "Stand inside a loaded trap bar with your feet shoulder-width apart.\n" +
                   "Squat and grasp the handles of the trap bar.\n" +
                   "Take a deep breath.\n" +
                   "Execution\n" +
                   "Keeping your torso upright and your arms and back straight, exhale as you lift the trap bar into a standing position.\n" +
                   "At the top of the movement, squeeze your glutes and pull your shoulders back.\n" +
                   "Inhale as you return the trap bar to the floor by first pushing your hips backward and then flexing your knees.\n" +
                   "Repeat for the prescribed number of repetitions.", R.raw.legs_trap_bar_deadlift);
               break;

           case 62: inserteerdata("LEGS", "dummbell step up",R.raw.legs_dummbell_step_up, "Starting position\n" +
                   "Holding a pair of dumbbells by your sides, stand facing a raised platform, such as a bench.\n" +
                   "Execution\n" +
                   "Exhale as you slowly step up onto the bench, leading with your right leg.\n" +
                   "Bring your feet together on the bench.\n" +
                   "Inhale as you slowly step down off the bench, leading with your right leg.\n" +
                   "Bring your feet together on the floor.\n" +
                   "Repeat, alternating the leg with which you step up and down off the bench.",R.raw.legs_dummbell_step_up);
               break;

           case 63: inserteerdata("LEGS", "hip thrust", R.raw.legs_hip_thrust, "Starting position\n" +
                   "Place a loaded barbell next to, and parallel to, a bench.\n" +
                   "Slide your legs under the barbell and sit on the floor with your back against the side of a bench. The barbell should be over your hips.\n" +
                   "Grasp the barbell at each side.\n" +
                   "Bend your knees and place your feet flat on the floor, approximately shoulder-width apart.\n" +
                   "Execution\n" +
                   "Keeping your torso rigid, exhale as you raise the barbell by extending your hips until they are fully extended.\n" +
                   "Hold for a count of two and squeeze your glutes.\n" +
                   "Inhale as you lower the barbell by flexing your hips. Do not allow the barbell to touch the floor.\n" +
                   "Repeat.", R.raw.legs_hip_thrust);
               break;

/*
           case 64: inserteerdata("TRICEPS", "Barbell Standing Triceps Extensions", R.raw.tribarbellextensions, "desription", R.raw.tribarbellextensions);
               break;

           case 65: inserteerdata("TRICEPS", "Skull Crusher",R.raw.triskullcrusher, "desription",R.raw.triskullcrusher);
               break;

           case 66: inserteerdata("TRICEPS", "Overhead Cable Triceps Extensions", R.raw.trioverheadextension, "desription", R.raw.trioverheadextension);
               break;


*/
       }

        }
    }

}
