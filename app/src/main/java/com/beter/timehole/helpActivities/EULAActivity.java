package com.beter.timehole.helpActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.beter.timehole.R;

public class EULAActivity extends AppCompatActivity {

    String eula = "\t\t\t\t\tThis End-User License Agreement (“EULA”) constitutes an agreement between you and E.T.E.R Studio (herein referred to as the “Owner”) with regard to the TimeHole " +
            "Application for Android-based Mobile Phones (herein referred to as “Software Product” or “Software”). By installing the Software, you are agreeing to be bound by " +
            "the terms of this license agreement.Your use of the Software (as specified below) is subject to the terms and conditions set forth in this EULA. If you do not " +
            "accept the terms of this EULA, do not install or use the Software. \n" +
            "\n" +
            "1. LICENSE. The Software is licensed, not sold. The Owner grants you a non-exclusive, non-transferable, non-sublicensable, limited right and license to use one " +
            "copy of the Software for your personal non-commercial use on a single device. The rights granted herein are subject to your compliance with this EULA. The Software " +
            "is being licensed to you and you hereby acknowledge that no title or ownership in the Software is being transferred or assigned and this EULA is not to be construed " +
            "as a sale of any rights in the Software.\n" +
            "\t\n" +
            "2. RESTRICTIONS OF USE. Unless the Owner has authorized you to distribute the Software, you shall not make or distribute copies of the Software or transfer the Software " +
            "from one device to another. You shall not decompile, reverse engineer, disassemble, include in other software, or translate the Software, or use the Software for any " +
            "commercial purposes. You shall not modify, alter, change or otherwise make any modification to the Software or create derivative works based upon the Software. You shall " +
            "not rent, lease, resell, sub-license, assign, distribute or otherwise transfer the Software or this license. Any attempt to do so shall be void and of no effect.\n" +
            "\t\n" +
            "3. COPYRIGHT. You acknowledge that no title to the intellectual property in the Software is transferred to you. You further acknowledge that title and full ownership rights " +
            "to the Software will remain the exclusive property of TimeTune Studio, and you will not acquire any rights to the Software. You shall not remove or obscure the Owner’s " +
            "copyright, trade mark or other proprietary notices from any of the materials contained in this package or downloaded together with the Software.\n" +
            "\t\n" +
            "4. DISCLAIMER OF WARRANTY. The Software is provided “AS IS”, without warranty of any kind. We disclaim and make no express or implied warranties and specifically disclaim " +
            "the warranties of merchantability, fitness for a particular purpose and non-infringement of third-party rights. The entire risk as to the quality and performance of the " +
            "Software is with you. We do not warrant that the functions contained in the Software will meet your requirements or that the operation of the Software will be error-free.\n" +
            "\t\n" +
            "5. LIMITATION OF LIABILITY. In no event will the Owner be liable for special, incidental or consequential damages resulting from possession, access, use or malfunction of " +
            "the Software, including but not limited to damages to property, loss of goodwill, computer or mobile device malfunction and, to the extent permitted by law, damages for " +
            "personal injuries, property damage, lost profits or punitive damages from any causes of action arising out of or related to this EULA or the Software, whether arising in " +
            "tort (including negligence), contract, strict liability or otherwise and whether or not the Owner has been advised of the possibility of such damages. Because some " +
            "states/countries do not allow certain limitations of liability, this limitation of liability shall apply to the fullest extent permitted by law in the applicable jurisdiction." +
            "This limitation of liability shall not be applicable solely to the extent that any specific provision of this limitation of liability is prohibited by any federal, state, " +
            "or municipal law, which cannot be pre-empted. This EULA gives you specific legal rights, and you may have other rights that vary from jurisdiction to jurisdiction." +
            "In no event shall the Owner’s liability for all damages (except as required by applicable law) exceed the actual price paid by you for use of the Software.\n" +
            "\t\n" +
            "6. PRIVACY AND ADVERTISING. This Software uses the Google AdMob advertising service. AdMob uses anonymous device identifiers to personalise content and ads, to provide social" +
            " media features and to analyse the traffic. AdMob also shares such identifiers and other anonymous information from your device with our advertising and analytics partners. " +
            "No private information is ever collected.\n" +
            "\t\n" +
            "7. INDEMNITY. You agree to indemnify, defend and hold the Owner harmless from and against any and all damages, losses and expenses arising directly or indirectly from: " +
            "(i) your acts and omissions to act in using the Software pursuant to the terms of the EULA; or (ii) your breach of this EULA.\n" +
            "\n" +
            "\tE.T.E.R Studio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eula);
        TextView eulaText = (TextView) findViewById(R.id.eulaText);
        eulaText.setText(eula);
    }
}
