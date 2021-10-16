//Name: Gabriel Doran
//Course: Java Development Fall 2021
//Instructor: Dr. Doderer

package project02Package;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.*;

import sentimentanalysis.Tweet;
import sentimentanalysis.TweetCollection;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
public class MainPanel extends JPanel {
	
	private TweetCollection tc;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField enterTweetTextField;
	
	public MainPanel()
	{
		tc = new TweetCollection("./sentimentanalysis/trainingProcessed.txt", 1600000);
		setPreferredSize (new Dimension(800, 500));
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(10, 11, 780, 478);
		add(tabbedPane);
		
		JPanel tab1 = new JPanel();
		tab1.setBackground(Color.LIGHT_GRAY);
		tab1.setToolTipText("Title");
		tabbedPane.addTab("Tab 1", null, tab1, "Title Page");
		tab1.setLayout(null);
		
		JTextPane txtpnSentimentAnalysisOf = new JTextPane();
		txtpnSentimentAnalysisOf.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 50));
		txtpnSentimentAnalysisOf.setBackground(Color.LIGHT_GRAY);
		txtpnSentimentAnalysisOf.setText("Sentiment Analysis of Tweet Data:");
		txtpnSentimentAnalysisOf.setBounds(10, 11, 755, 57);
		tab1.add(txtpnSentimentAnalysisOf);
		
		JTextPane txtpnCreatedByGabriel = new JTextPane();
		txtpnCreatedByGabriel.setBackground(Color.LIGHT_GRAY);
		txtpnCreatedByGabriel.setText("Created by Gabriel Doran");
		txtpnCreatedByGabriel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtpnCreatedByGabriel.setBounds(10, 91, 201, 27);
		tab1.add(txtpnCreatedByGabriel);
		
		JTextPane txtpnSoftwareDevelopmentJava = new JTextPane();
		txtpnSoftwareDevelopmentJava.setText("Software Development Java Fall 2021");
		txtpnSoftwareDevelopmentJava.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		txtpnSoftwareDevelopmentJava.setBackground(Color.LIGHT_GRAY);
		txtpnSoftwareDevelopmentJava.setBounds(10, 68, 292, 32);
		tab1.add(txtpnSoftwareDevelopmentJava);
		
		URL myInputStream = getClass().getResource("twitterlogo.png");
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(myInputStream));
		lblNewLabel.setBounds(173, 129, 458, 302);
		tab1.add(lblNewLabel);
		
		JPanel tab2 = new JPanel();
		tab2.setToolTipText("Tab 1");
		tab2.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Tab 2", null, tab2, null);
		tabbedPane.setBackgroundAt(1, Color.LIGHT_GRAY);
		tab2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 73, 273, 295);
		tab2.add(scrollPane);
		
		JTextArea txtrTweetsonly = new JTextArea();
		txtrTweetsonly.setText("1598315 tweets (only 200 are shown):\r\n[ID: 1979741696, polarity: 0] Tommro: @JoshLoveMC lol it should be good; got my A levels this week \r\n[ID: 2046851584, polarity: 0] OMJitsNi: dylan and cole sprouse - i cant tell em apart in this movie . LOL  cyring atm \r\n[ID: 2197848833, polarity: 0] _Bleach: has just watched bb; and now watchin big bang theory; big day of work ahead gotta be up at 7am \r\n[ID: 1694524674, polarity: 0] navdhanja: Oh...I liked having facial hair...I could have fun disguising myself...back to the old fashioned way of fake nose and glasses \r\n[ID: 2000713539, polarity: 0] ohmyginanes: on my way home. i hate homework; it ruins a perfectly good night \r\n[ID: 1556110532, polarity: 0] iminlikewith: I lost my on a good day cd that i bought on the streets of chicago; lets hope that itll give the person who finds it a good day. \r\n[ID: 2193654468, polarity: 0] tonightles: @cupidshotme the message for the titans? hahaha okay but I wanna go that  I extinguished the fire too hehe\r\n[ID: 2206237573, polarity: 0] Yerucit: Goog morning Twitter! i\u00C3\u201A\u00C2\u00B4m with headache and Fluuuu... \r\n[ID: 1967158600, polarity: 0] jennifer_rose: awesome lunch date today  work 7-2 tomorrow  then with the boyfriend &lt;3 xo\r\n[ID: 1686135949, polarity: 4] richokineti: @nanoraptor I'm fairly sure miss pixie ears needs a new avatar; maybe pop it on you're list of things to do? \r\n[ID: 2231403799, polarity: 0] Daniel_Hairsto: @DrSeussFreak That makes two of us ... \r\n[ID: 2063629085, polarity: 4] clarasdiar: @Anii_love_JoNaS hopefully I'll win the trip to the JB concert on June 14th with Imke  fingerscrossed!! #kevinjonas!\r\n[ID: 1979741727, polarity: 0] asmileforyo: has a few 'gamu-gamo' flying around in my room.  http://plurk.com/p/xdp08\r\n[ID: 2202043234, polarity: 0] MorganSpai: yay for tomorrow! boo for shin splints \r\n[ID: 1572888043, polarity: 4] MegDanielle2: procrastinating alot of stuff...but its fine...summer in one week \r\n[ID: 1572888044, polarity: 4] StephCeC: I just completely rearranged my schedule for next semester...I hope that was a good idea!  At least I have Fridays off!! \r\n[ID: 2252375661, polarity: 0] cfortso: UUGHH!!! For some reason my collage saved to be tiny and I can't make it bigger!!! \r\n[ID: 1979741744, polarity: 0] Clarine: BBQ with step bro JeremyCosta and JJ. They're going back 2 Canada this wednesday. Will miss u! \r\n[ID: 2181071410, polarity: 0] ericaa1: @jwadlington I have to work until 4 Friday   Chad wants to go ahead and get the $99 one though.\r\n[ID: 1996519224, polarity: 4] _ChelseaC: @xBabyV really? do you know who hacked you or anything? but im sure if you give it a day or 2 you will have thousands of followers haha \r\n[ID: 2193654523, polarity: 0] chrisnt: Hmm not tweeted for a #squarespace iPhone in awhile so here's a tweet for all to see. Shame other companies are going for the same idea \r\n[ID: 2206237635, polarity: 0] KristennCHAO: Trying not to think of what I'm missing tonight to keep from getting really upset \r\n[ID: 2202043140, polarity: 0] allyshay: is at home all by herself and doesn't know what to do.  things to do: watch friends; sleep; laundry; i don't know. meh.\r\n[ID: 1686136006, polarity: 4] sany: @pattycular meh thanx \r\n[ID: 2046851657, polarity: 0] dancer2techi: @seekinspiration Aaaw; I never got this message! The one where you thanked me....  And you're welcome!\r\n[ID: 1996519241, polarity: 4] samaraMEO: Watching Jay Leno with my daddyo - hillarreeoussss! \r\n[ID: 2223015119, polarity: 0] CindyBon: I have NO idea what I'm doing . . . need to make a doctor's appointment but I'm too scared to find out what's going on!  \r\n[ID: 1996519250, polarity: 4] Sock: See you all tomorrow \r\n[ID: 2059434643, polarity: 0] cata030: i miss my friend \r\n[ID: 2004908003, polarity: 0] pure_believe: @onebreath Plus; poor Season 3 was cut short due to the writer's strike.  As were all the rest of my favorite shows; lol.\r\n[ID: 1686136035, polarity: 4] PunkFe: I've Just finished learn We Are The Young. Love this song \r\n[ID: 2243986853, polarity: 0] Jewels_x: @cntrstrk14 I've been having that problem the past couple days; too. \r\n[ID: 2193654438, polarity: 0] nkotblori: @sev215   i hope i'm in that 'real' category too!\r\n[ID: 2218820649, polarity: 0] alexthebanan: The Good: I got two adorable new hamsters - Remus and Ace! The Bad: they smell. The Worst: I'm allergic to them. \r\n[ID: 1967158571, polarity: 0] Boddington: @architeuth1s hey...and you didn't bring me with you *sniff* \r\n[ID: 1572887984, polarity: 4] SlytherinBab: so im home...gonna get sum things tomorrow..gonna see grandma the nxt day and the nxt im gonna hang out with Jay  funn!\r\n[ID: 1996519281, polarity: 4] KristenCampis: @Patricia_Knight back and ready to attack...;) Well; not really...but it rhymed? kinda? \r\n[ID: 1686136051, polarity: 4] siite: Whole day fun with bffs and still continue.. \r\n[ID: 1996519286, polarity: 4] mariakitan: @TeresatheGG yes almost a day off lol . I had a whole week off this winter when i had the flu but that was just forced time off \r\n[ID: 2055240439, polarity: 0] inapi: im trying to figure out the way i feel :-s im sick and tired of how he is to me; but he's all i want \r\n[ID: 2063629175, polarity: 4] nancy_m: I'm on a super high right now!! cheer up everybody; after all....doot da doo life's good! priority @mileycyrus tickets BO'YEAH  xoxo\r\n[ID: 2227209400, polarity: 0] danidooy: is getting ready to go to the hangout;its my last day in gulf shores \r\n[ID: 2202043194, polarity: 0] Lissafe: Getting bed early for once long day tomorrow. Gym early; then LA.. Not for the laker parade though..Traffic is gonnna be epic \r\n[ID: 2210431931, polarity: 0] amy_babes9: @ThelionRobert y coz ur hardly in it ? .. im so sorry im lettin me anger out on u .. but u took me m8s away 4rm me  .x\r\n[ID: 1971353085, polarity: 0] DK121: @jerseygirl4u I know but I still packing and shit to do before u get here. \r\n[ID: 1572887999, polarity: 4] missabab: @Asbo_T Oh yeah.Tons of fun.I'm leaving directly from karaoke for that long ass boring drive.Oh wells;I'm going to have a great weekend \r\n[ID: 2176876873, polarity: 0] wenchfaer: says awake after no sleep *again*. My body hates me.  http://plurk.com/p/112t0j\r\n[ID: 2252375756, polarity: 0] Sarah_Etoil: Has so much art to do  and left the fecking powder paints at school :@!!\r\n[ID: 1686135825, polarity: 4] ramboni: @philiplavoie thanks buddy; coffee and a donut helped \r\n[ID: 1996519320, polarity: 4] iPil: @mitchelmusso I love your new CD. Keep on rocking. Great taste in music. \r\n[ID: 1564499423, polarity: 0] Violetistigh: Only halfway done typing my essay  I still have to shower!!!\r\n[ID: 2227209312, polarity: 0] Cinetuyoymi: @AshmiNYC Yo s\u00C3\u0192\u00C2\u00A9! Y eso es lo divertido: me aparecen tus replies; but that's it! \r\n[ID: 1996519334, polarity: 4] Abbyy: Pool with mollie \r\n[ID: 2063629223, polarity: 0] Siouxsinne: @Katsweat nope I haven't seen anything gotta wait until July \r\n[ID: 2063629224, polarity: 0] chrisssy: Arrgh! I'm soo tired! Like 3hours sleeep!! \r\n[ID: 1686135849, polarity: 4] amansharma8: @surachart @siprasad  hehe I already did a dark copperish over the front spikes ; it was enough to give lots of mgrs hrt attcks \r\n[ID: 1992324714, polarity: 0] Dostana9: how the heck am i going to survive a week without Ei-chan and Junnie?  Forever crying under my skin.\r\n[ID: 2302708204, polarity: 0] Sara_Danielle: @JakersTheTeddy you are so mean \r\n[ID: 1996519340, polarity: 4] kyleracci: @downtheticket We're taking bets on how long it will take the lefty gay groups to *cough* praise Cheney \r\n[ID: 2210431856, polarity: 0] rachelreube: @MrCirce Yes you were; but it's not going well for me. Zimbra calendar &amp; contacts are gone.  Going to see sysadmin for help now. (\r\n[ID: 2055240251, polarity: 0] gregavol: @cdoublev yeah - this time for good  hardware test showed a faulty processor - sad day\r\n[ID: 2013296830, polarity: 0] jeanneherawat: lose again 5-1 ?? ngokk; ckckck \r\n[ID: 1971352900, polarity: 0] rynomar: Woke up at 3am and realized the house had not cooled off! The compressor is running and cold but no air. No one can come out until Mon. \r\n[ID: 1572887816, polarity: 0] MonochromeRai: @bizarrejelly My thoughts exactly. I really can't stand his voice  Don't tell the fangirls.\r\n[ID: 1996519369, polarity: 4] ethanha: @Girliegrl10 wednesday. ! ! I'm so excited \r\n[ID: 2302708111, polarity: 0] clairyberr: @sebadugalski hhmmmm jealous!! i want to be in the sun \r\n[ID: 2214626519, polarity: 0] wrestlingaddic: @SoccerMomof1 thanks hun; I hope he starts feeling better soon but it looks unlikely  they said not much time left \r\n[ID: 2227209245, polarity: 0] Maggs: @i_am_girlfriday I feel you. Matt I'd looking at more furlough time. \r\n[ID: 1686135908, polarity: 4] sarahhh: @andyclemmensen its okay its only 10.00 for us perth kiddos \r\n[ID: 1996519396, polarity: 4] MsMaria2: @MrFresh0587 yeah. get a blackberry \r\n[ID: 1975547181, polarity: 0] YoAriann: Each day I hope is the day turns out a disappointment and I realize I just don't mean that much to you anymore... \r\n[ID: 2302708147, polarity: 0] bohemian_dol: @mrMoros No? I didn't get it  but yay for finally having your iPhone; best thing ever!\r\n[ID: 2063628802, polarity: 4] JaneAngeliqu: To my dear followers; can you do me a favor?  Could you please tell your followers to follow me? Thanks alot!\r\n[ID: 2176876741, polarity: 0] diana_celi: in the word of the in-famous &quot;The bangles&quot; band; it's mondsy; i wish it was sunday cause that's my fun day; my i don't have to run day. \r\n[ID: 1564499024, polarity: 0] WhoseLineRule: I hate today. I'm so tired. I don't want to day anything this week. Good thing I have three projects due Thursday I've barely started. \r\n[ID: 1572887764, polarity: 0] jeaneMAKEU: I'm so jelious of all the rain that everyone is getting. It almost never rains where I live \r\n[ID: 2264958486, polarity: 0] antonleub: ah great; I left my balcony door open while brushing my teeth and now my apartment smells like an ash tray... Why; smokers? Why? \r\n[ID: 2004907681, polarity: 0] rstysta: yea i miss him more and more every second \r\n[ID: 2256570279, polarity: 0] sarawha: Really really really don't want to go back to the city \r\n[ID: 1686136232, polarity: 4] RealJadeMoira: ....will be a fun day indeed!! Birthday 2mro (yay 4 me again!!) So looks as thou i shall be in a good mood  xx\r\n[ID: 2059434987, polarity: 0] mitsa: I'm kinda sad cos my crazy fast web browser on my phone has stopped working.... Depresseedddddddddddddddddddd \r\n[ID: 2063628844, polarity: 4] coolashake: @lauzc87 Fighting facebook again!?  The weekend is all good! Gym &amp; holiday prep today. Need caffeine to get me through the day\r\n[ID: 2231403565, polarity: 0] IvanVi: I can't move my left arm \r\n[ID: 1975547125, polarity: 0] ChloeLovesE: @VickyMinor Chris grabbed my arms and mum grabbed my legs then they shoved me in a bin took my phone and took photos of me  unhappy face\r\n[ID: 2264958519, polarity: 0] deadmem0rie: ... hate sundays \r\n[ID: 2206237368, polarity: 0] snoslicer: @theotherAP At least you'll get to use #iPhone3.0 right away! I hafta wait until Friday for the unlock. \r\n[ID: 2004907726, polarity: 0] TanyaFany: My allergies are really bad this morning--I've got the sniffles \r\n[ID: 2051046158, polarity: 0] Eittapnny: ouch!!!!!!  \r\n[ID: 2243986574, polarity: 0] littlevixe: just got out the pool.... no beach today \r\n[ID: 2000713231, polarity: 4] Elyys: @DontStayIn_com  nice new logo! I have an advertising Q for you actually.. Could I have your email address?  elyse@randyboyer.com is mine\r\n[ID: 2206237402, polarity: 0] kraebe: No annual 4th of July party at the Belden's this year. Boo.... \r\n[ID: 2302707745, polarity: 0] smorgs8: @Amylou890 i cant see the pic bcuz im at work right now \r\n[ID: 1996519012, polarity: 4] KatieCur: away to watch family guy \r\n[ID: 1971352809, polarity: 0] MeliGarzo: stitches on my foot \r\n[ID: 2214626665, polarity: 0] Panea: Bored; Abbey playing peek a boo &amp; doesn't want me to play  rejected by a 1 year old\r\n[ID: 2063628910, polarity: 4] gravmeher: @lavinal yup yup yup! \r\n[ID: 1686136303, polarity: 0] caryn82: Sick sick sick. Nose running like crazyyy and I sound like a duck now \r\n[ID: 2063628928, polarity: 4] Bout_ye: Need 2give my body a break too much drink this week! Last night was fucking random!  18-28....that's a big age gap right!:p hahaha\r\n[ID: 2231403653, polarity: 0] HeyAshleyHe: @despairgirl and i have to watch my sissy; my dad's in the hospital \r\n[ID: 2298513542, polarity: 0] BurningHawk196: still tweaks me that I can't piece Sunday night together. I really hope I didn't do something hideously obnoxious and rude... \r\n[ID: 1686136071, polarity: 0] AKTheCrushe: Wah; I love Opera Link; but I hate the duplicating that happens all the frickin' time! I DON'T GOT 50 000 BOOKMARKS; SERIOUSLY \r\n[ID: 2302707916, polarity: 0] katie_bee12: Last day of School EVER Today! \r\n[ID: 1572887632, polarity: 0] ieatseippu: @trent_reznor And that is why we fans have a bad rep  Though it was kinda funny....\r\n[ID: 1979742099, polarity: 0] nathanfortyon: Almost time to leave the ship   but only a week till bonnaroo!\r\n[ID: 1556110677, polarity: 0] TwiterTweete: Seventeen again was great; reeses peanut buttercups x2; twix x2 = Me about to be sick \r\n[ID: 2302707926, polarity: 0] cassiegirl0: Is it cuz of the contest??? I hope they won't unsub when it's over \r\n[ID: 2000713435, polarity: 0] cukissc: @JasonReso I hope to have more luck tomorrow to see ECW had a lot of work today and it is time not finish \r\n[ID: 2252376030, polarity: 0] OGWalke: going to get ready for a meal! cant find the wine  have looked everywhere. x\r\n[ID: 1979742118, polarity: 0] savagesta: @aphrodaisy What's going on; sweetie? \r\n[ID: 1753245991, polarity: 0] glossmenageri: My desk looks like a disaster zone. Yet again. How does it get sooo messy SO fast??? Help me. \r\n[ID: 2176876647, polarity: 0] markbush: It's official faith no more at Reading only 2 months of waiting \r\n[ID: 1694524586, polarity: 0] RiaTolsto: yeeaaaa typical bank holiday monday in blighty - it's a gonna rain! for a change...still gonna get me treader out and get wet whoop whoop \r\n[ID: 1996519084, polarity: 4] IAmAlexSuave: @favoritemelody yay!!!!!  So; are we going to do one epic video train?\r\n[ID: 1694524590, polarity: 0] olafsearso: @nessie111 Thanks! I'm good ta. I'm not sure if I like the pic. Just noticed my slightly receeding hairline  xx\r\n[ID: 1967158513, polarity: 0] f0ll0wMar: @kidstylez how u gonna ask for a GoGo n u aint even goin \r\n[ID: 2063628983, polarity: 4] CharmsOfLigh: Off to my daughters football tournament. Hope the sun stays shining! Tweet you later! \r\n[ID: 2063628991, polarity: 0] hannahlizabet: fell over in estab last night and my head still hurts  hypochondria is making me fear internal bleeding haha\r\n[ID: 2214626752, polarity: 0] MoBitche: Has lupis and could use a visit from the doctor \r\n[ID: 2000713354, polarity: 0] bkGirlFrida: @typezero3  still coughing but good. im still raspy. \r\n[ID: 2214626762, polarity: 0] smpamllfufv1: im on the computer and texting at the same time. while i hear the weather say there is a tornado somewhere north of me. \r\n[ID: 2063629003, polarity: 4] HannaGerk: @Alyssa_Milano What are you doing in Utah??  Is it for your new TV Show?\r\n[ID: 2063629010, polarity: 4] jessicannamari: I'm baking. And cleaning. For som reason mom invited her entire class home tomorrow.. why beats me. But I get to cook and clean \r\n[ID: 1996519126, polarity: 0] powpowSHABAN: noooo; no more PEZ \r\n[ID: 2051046294, polarity: 0] BigMacBrisban: Flat tire was flat; So I decided to pump it up. Damn those things make a loud band noise when they explode &gt;.&lt;  no riding for me\r\n[ID: 1694524631, polarity: 0] givemestrengt: Couldnt get a ticket for Lily Allen in Plymouth for November  @lilyroseallen can you release just 1 more; just for little ole me x\r\n[ID: 2063629015, polarity: 4] beccaweek: @_shannonx33 the jonas brothers youtube account got suspended because of joe's dance :S its on oceanup.com \r\n[ID: 2059434778, polarity: 0] olson: The Olson family has been sick for several days.  We had some big plans for the weekend which have been thrown out now \r\n[ID: 1686136159, polarity: 4] eladmeida: why i don't recognize any handler in #rubyonrails ? where have all the cowboys gone? \r\n[ID: 2218821025, polarity: 0] shaneschofiel: 3 days left on my gym membership   Not renewing.\r\n[ID: 1996519145, polarity: 4] arpeli: @what_ho It is! Spicy and delicious \r\n[ID: 2298513644, polarity: 0] __Maxi_: @lovelynicols only i must talk with my dad.. you know Bwr test \r\n[ID: 1996519149, polarity: 4] mattbuck_hac: Interesting night at #winchesterweb - perhaps the politicians and the web developers can help find a business plan for journalism \r\n[ID: 2218821039, polarity: 0] Sabk: @iitsMolly thanks for adding to my confusion. \r\n[ID: 2059434804, polarity: 0] veronica_nen: waitn for my gyrl Dinae to swing through visitin from Dirty Jerz....my baby gyrl jus went to her end of the yr formal dance  i'm getti ...\r\n[ID: 2231403765, polarity: 0] ayeyacki: PISSED OF THAT THIS WEEK IS FUCKEN OVER  i HAVE TO GO BACK TO skool (ugh)\r\n[ID: 1996519161, polarity: 0] SylviaWh: Im really sad that I didn't get warped eco  hopefully I can still go.\r\n[ID: 1996519166, polarity: 4] RobertShippe: @itscalum010 just write a load of crap that is vaguely related to the topic and you'll be fine \r\n[ID: 2197848325, polarity: 0] LeeCont: Brooke Kinsella in excellent knife crime documentary on BBC One. Her little brother Ben died a year ago \r\n[ID: 2063628553, polarity: 4] smidgalen: is hanging; such an awesome night \r\n[ID: 1686136464, polarity: 4] PercythePigeo: @HelenLeathers Hi;I will check out 'the secret'  Great charities.\r\n[ID: 1996518672, polarity: 4] jeffkar: waiting to hear back from some blog admins. \r\n[ID: 2063628561, polarity: 4] staceyelain: @adamchickey Good luck! Can't wait to read of your adventures \r\n[ID: 1753246354, polarity: 0] AnnieDukeNStuf: @ZeeNemesis wow. 1. Mean. 2. I always want to hang out with u... 3. That's not fair... \r\n[ID: 2202042707, polarity: 0] tpotb9: So I can't watch True Blood tonight.  Damn It!! I want my vampire sex!  What a tease \r\n[ID: 1572888537, polarity: 4] bunnieLU: @ddlovato turn that frown upside down \r\n[ID: 1686136473, polarity: 4] tinkamell: @RubyRose1 Ask Alex if needs a receptionist / personal assistant... YEAH!! \r\n[ID: 2063628571, polarity: 4] minority: @ohhaikelly 3 weeks haha \r\n[ID: 2193653980, polarity: 0] TKM: @MsOrangeCounty It's Sad isn't it... Lena is trying to completely purge Jeffree from her life \r\n[ID: 2252375138, polarity: 0] orlaaaaa9: @bellexx nope didnt find my camera \r\n[ID: 2185265251, polarity: 4] tweeteradder1: @231rent Get 100 followers a day using www.tweeterfollow.com Once you add everyone you are on the train or pay vip \r\n[ID: 2302708580, polarity: 0] fabioxg: Out of beers \r\n[ID: 2063628581, polarity: 4] bluebellbo: back from my hol in spain.... weather was fab... back 2 cold winds and 13 degrees  had a brill time out \r\n[ID: 2185265253, polarity: 4] sawyercuti: outside on the back deck with my birthday boy waiting on willie and heather \r\n[ID: 2202042730, polarity: 0] tylermcfarlan: @alyssatoland Ugh I hate Summer Reading!  Lol; so did you get accepted into Global High?\r\n[ID: 1971353515, polarity: 0] musik_frea: and brian your totaly insane!!!!!!  miss your crazyness and energy  pleasssssse come back soon!\r\n[ID: 2323679403, polarity: 0] faiznurdavi: @fanafatin fatinnnnnnnn :'( I'm gonna miss u too! Really  today's the day! time flies so fast  babe! take care k! keep in touch! \r\n[ID: 1992324341, polarity: 0] K_Lowe: I've had such a bad day  but I'm away home early to enjoy the sunshine\r\n[ID: 2197848375, polarity: 0] vickiebo: @ngowers tweetdeck has been crashing on me for weeks \r\n[ID: 2063628600, polarity: 4] pamistr: updating! has The Sims 3 in her phone. \r\n[ID: 1996518713, polarity: 4] DONDIT: @sabina_enn thanks \r\n[ID: 2000712963, polarity: 0] hellocourtneyy: Of course fun weekends have to end and are followed by a full day of school \r\n[ID: 1753246405, polarity: 0] lavr: These cramps are killlin' my party mood \r\n[ID: 1677747782, polarity: 4] boxbl: Too difficult to take pics as they are directly facing me! Will hopefully nab a few snaps afterwards. Very friendly guys \r\n[ID: 2202042633, polarity: 0] rachammon: You know that key between the f and h? yeah mine doesnt work \r\n[ID: 2235598604, polarity: 0] heyyouhats: must kiss bureaucratic ass for money \r\n[ID: 1996518734, polarity: 4] izabell: @BobbyLongNews  lol that one wish i was in berlin\r\n[ID: 1686136530, polarity: 4] AtiaAbaw: @CentCaps Heading to a place where I can sleep; walk around freely and laugh a bit with a good friend \r\n[ID: 1983935506, polarity: 4] KAYLA_x: mtv movie awards tonightt! \r\n[ID: 1983935507, polarity: 4] Bohunia: Return To The Forbidden Planet was amazing! i really do miss performing it; especially because i loved the outfits haha! \r\n[ID: 1979741268, polarity: 4] mandy1070: @AAband (Y)  x Can't Wait To See Youuz In Derby  x\r\n[ID: 1677747798, polarity: 4] WhichWitch7: @Madhobbit/Eerie;how olds tha building?Whats it used 4?Dyu mind me askn Qs or wud u prefer2 just post ur updates &amp; get on with it? Suz \r\n[ID: 2063628632, polarity: 4] karlomar: says hello! the cute is back!  http://plurk.com/p/z1wd0\r\n[ID: 2051045402, polarity: 0] 6omm: Twitterrific shows an ad from Wacom's INTUOS4... remembers me how much I want one  http://twitpic.com/6pw3a\r\n[ID: 2243987356, polarity: 0] devonkate0: would really love to know why there is never anything decent on the tv anymore \r\n[ID: 1572888483, polarity: 0] imjustcreativ: @DurbinDigital Well no; but they all have different size canvas areas; which just takes time; like coroflot is different again \r\n[ID: 2256569573, polarity: 0] Krispy: @wchardin He did look very sad didn't he..it's a shame because I thought he was quite nice; they just edited him badly \r\n[ID: 2059434151, polarity: 0] njones0: The switcher died in the middle of the service... That's always good when just a couple thousand people are watching \r\n[ID: 1979741288, polarity: 4] itsjustreallym: i love spongebob squarepants!  watching it rite now.. o.o LOL.. lame// \r\n[ID: 2176877483, polarity: 0] LuckedOutLif: Well good morning - I'm totally tired - and don't feel like moving - but better get my act in gear....Hate MONDAYS! \r\n[ID: 2231404400, polarity: 0] minchooki: good morning tweeeet! heading to school in a bit \r\n[ID: 2059434163, polarity: 0] HenryDotSig: Do we need war to make peace ? ....Do I need my place get messy before it gets clean?  - Philosophical but reality.\r\n[ID: 1996518771, polarity: 4] brittjona: @Jonasbrothers i loveeeee the new songs! (L) i can't wait for the new album; it's going to be amaaaaazing \r\n[ID: 2000713017, polarity: 4] JRKNaughtyNurs: @Covergirl1985 @NKOTBFlamesFan me three \r\n[ID: 1686136571, polarity: 0] meganwilde: Who serves coffee @ 6am on a Sunday in Sleasley; SC...? \r\n[ID: 2231404412, polarity: 0] bacieabbracc: @amous Awwwww....sorry 2 hear that \r\n[ID: 1572888385, polarity: 4] angelisti: @tweenkiebelle I dont know my dear \r\n[ID: 2051045573, polarity: 0] BunnyJeanCoo: @PepperTheDog i iz gud Peppah - just trying to figure out how to get back into Tweetdeck. i don't like to twitter on the web. \r\n[ID: 2063628677, polarity: 4] frombecc: @WayneMansfield @janiecwales @chin2to thx for #shareasmilesunday *smiles*   )))\r\n[ID: 1572888391, polarity: 4] nanne: @oleglo Me too; boo. I was just thinking the same thing. You can call me \r\n[ID: 2323679241, polarity: 0] jayyyeee: About to read 'new moon' before bed. tomorrow is family day. Our baby has been in south city for a week and is leaving again for tahoe \r\n[ID: 2298514314, polarity: 0] Vanessa_Muni: @Brookie610: hahahaha i knowwww.. i want to go soooo bad  i'm seriously thinking about going myself.. but i won't hahaha\r\n[ID: 2214626956, polarity: 0] chesi6: i'm home sick  but at least exams are over now XD\r\n[ID: 2193653838, polarity: 0] eunique8: @damarisviviana naw they have all the streaming websites blocked n i left my ipod @ home  and sade is the artist\r\n[ID: 2214626958, polarity: 0] robertholida: @Wise_Diva just a tad bit over the top \r\n[ID: 2000713169, polarity: 4] womanhunte: It's about that time......good night &amp; God bless \r\n[ID: 2063628689, polarity: 4] FoOi: @simontay78 haha; wanna trade / sell them? \r\n[ID: 1572888403, polarity: 4] J0SMILE: SO DON'T DO IT \r\n[ID: 1992324180, polarity: 0] AlyGree: @Mizcity yeah i noticed that just now  there were a bunch of tickets left when i checked friday... oh well\r\n[ID: 2055239700, polarity: 0] xdamma: There is really nothing interesting in cinemas right now... And Belgium is the only country with no free pojection of #home \r\n[ID: 1572888413, polarity: 0] Diyen: says I'm bored really  http://plurk.com/p/pan00");
		scrollPane.setViewportView(txtrTweetsonly);
		
		JTextPane polSliderDisplayTextPane = new JTextPane();
		polSliderDisplayTextPane.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		polSliderDisplayTextPane.setBounds(349, 121, 399, 305);
		tab2.add(polSliderDisplayTextPane);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			@SuppressWarnings("null")
			public void stateChanged(ChangeEvent e) {
				//Slider
				Set<Long> setAllTweetIDs = tc.getAllTweetIds();
				Set<Tweet> setTweetsP0 = null, setTweetsP2 = null, setTweetsP4 = null;
				Tweet currentTweet = new Tweet(0, 0, " ", " ");
				
				for (Iterator<Long> myIterator = setAllTweetIDs.iterator(); myIterator.hasNext(); ) {
					Long currentID = myIterator.next();
					
					for (int i = 0; i < setAllTweetIDs.size(); i++) {
						currentTweet = tc.getTweetById(currentID);
						
						if (currentTweet.getPolarity() == 0) {
							setTweetsP0.add(currentTweet);
						}
						else if (currentTweet.getPolarity() == 2) {
							setTweetsP2.add(currentTweet);
						}
						else {
							setTweetsP4.add(currentTweet);
						}
					}
				}
				
			
				if (slider.getValue() == 0) {
					polSliderDisplayTextPane.setText(setTweetsP0.toString());
				}
				else if (slider.getValue() == 2) {
					polSliderDisplayTextPane.setText(setTweetsP2.toString());
				}
				else {
					polSliderDisplayTextPane.setText(setTweetsP4.toString());
				}
			}
		});
		slider.setBorder(new LineBorder(new Color(0, 0, 0)));
		slider.setPaintLabels(true);
		slider.setMaximum(4);
		slider.setMinorTickSpacing(2);
		slider.setValue(2);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setBounds(447, 73, 200, 41);
		tab2.add(slider);
		
		JTextPane txtpnTweetsByPolarity = new JTextPane();
		txtpnTweetsByPolarity.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtpnTweetsByPolarity.setBackground(Color.LIGHT_GRAY);
		txtpnTweetsByPolarity.setText("Tweets by Polarity:");
		txtpnTweetsByPolarity.setBounds(474, 44, 200, 31);
		tab2.add(txtpnTweetsByPolarity);
		
		JRadioButton rdbtnShowData = new JRadioButton("Show data");
		buttonGroup.add(rdbtnShowData);
		rdbtnShowData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Show
				txtrTweetsonly.setVisible(true);
			}
		});
		rdbtnShowData.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		rdbtnShowData.setBounds(63, 44, 109, 23);
		tab2.add(rdbtnShowData);
		
		JRadioButton rdbtnHideData = new JRadioButton("Hide data");
		rdbtnHideData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Hide
				txtrTweetsonly.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnHideData);
		rdbtnHideData.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		rdbtnHideData.setBounds(201, 44, 109, 23);
		tab2.add(rdbtnHideData);
		
		JPanel tab3 = new JPanel();
		tab3.setToolTipText("Tab 2");
		tab3.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Tab 3", null, tab3, null);
		tab3.setLayout(null);
		
		JTextPane txtpnRetrieveARandom = new JTextPane();
		txtpnRetrieveARandom.setBackground(Color.LIGHT_GRAY);
		txtpnRetrieveARandom.setText("Retrieve a Random Tweet:");
		txtpnRetrieveARandom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtpnRetrieveARandom.setBounds(269, 11, 212, 33);
		tab3.add(txtpnRetrieveARandom);
		
		JTextPane randomTweetTextPane = new JTextPane();
		randomTweetTextPane.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		randomTweetTextPane.setBounds(128, 137, 500, 70);
		tab3.add(randomTweetTextPane);
		
		JButton btnClickMe = new JButton("CLICK ME!");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sizeOfAllTweetIDs = 0, randomNum = 0, index = 0;
				Long randomTweetID = null;
				Tweet randomTweet = new Tweet(0, 0, " ", " ");
				String randomTweetS = " ";
				
				Set<Long> setAllTweetIDs = tc.getAllTweetIds();
				
				sizeOfAllTweetIDs = setAllTweetIDs.size();
				
				randomNum = (int) (Math.random() * (sizeOfAllTweetIDs - 1) + 1);
				
				for (Iterator<Long> myIterator = setAllTweetIDs.iterator(); myIterator.hasNext(); ) {
					Long myLong = myIterator.next();
					
					if (index == randomNum) {
						randomTweetID = myLong;
					}
				}
				
				randomTweet = tc.getTweetById(randomTweetID);
				randomTweetS = randomTweet.toString();
				
				randomTweetTextPane.setText(randomTweetS);
			}
		});
		btnClickMe.setForeground(new Color(0, 0, 0));
		btnClickMe.setBackground(Color.BLUE);
		btnClickMe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnClickMe.setBounds(295, 55, 144, 50);
		tab3.add(btnClickMe);
		
		JPanel tab4 = new JPanel();
		tab4.setToolTipText("Tab 3");
		tab4.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("New tab", null, tab4, null);
		tab4.setLayout(null);
		
		JTextPane txtpnPredictMyTweet = new JTextPane();
		txtpnPredictMyTweet.setBackground(Color.LIGHT_GRAY);
		txtpnPredictMyTweet.setText("Predict My Tweet!!!");
		txtpnPredictMyTweet.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtpnPredictMyTweet.setBounds(301, 11, 158, 32);
		tab4.add(txtpnPredictMyTweet);
		
		enterTweetTextField = new JTextField();
		enterTweetTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		enterTweetTextField.setBounds(133, 70, 500, 45);
		tab4.add(enterTweetTextField);
		enterTweetTextField.setColumns(10);
		
		JTextPane predictedPolarityTextPane = new JTextPane();
		predictedPolarityTextPane.setFont(new Font("Times New Roman", Font.BOLD, 18));
		predictedPolarityTextPane.setBounds(357, 222, 39, 45);
		tab4.add(predictedPolarityTextPane);
		
		JButton enterTweetButton = new JButton("Enter Tweet");
		enterTweetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputTweet = enterTweetTextField.getText();
				Tweet predictThisTweet = null;
				int tweetsPol = 0;
				Tweet predictedTweet = new Tweet(0, 0, " ", " ");
				
				//**THIS DOES NOT WORK*** Need to convert from String to Tweet.
				
				tweetsPol = tc.predict(predictThisTweet);
				predictedTweet.setPolarity(tweetsPol);
				
				predictedPolarityTextPane.setText(predictedTweet.toString());
			}
		});
		enterTweetButton.setBounds(26, 81, 97, 23);
		tab4.add(enterTweetButton);
		
		JTextPane txtpnFormatPolarity = new JTextPane();
		txtpnFormatPolarity.setBackground(Color.LIGHT_GRAY);
		txtpnFormatPolarity.setText("Format: polarity (0, 2, 4), ID, username, Tweet");
		txtpnFormatPolarity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txtpnFormatPolarity.setBounds(133, 115, 326, 20);
		tab4.add(txtpnFormatPolarity);
		
		JTextPane txtpnPredictedPolarityIs = new JTextPane();
		txtpnPredictedPolarityIs.setBackground(Color.LIGHT_GRAY);
		txtpnPredictedPolarityIs.setText("Predicted polarity is...");
		txtpnPredictedPolarityIs.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtpnPredictedPolarityIs.setBounds(288, 179, 194, 32);
		tab4.add(txtpnPredictedPolarityIs);
	}
}