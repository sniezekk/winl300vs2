//Initialize
graph = JanusGraphFactory.open('conf/janusgraph-cql.properties')
tx = graph.traversal().tx()
g = tx.begin()

// delete previous data
g.V().drop()

// ~~~~ Types ~~~~
condition = 'Condition'
drug = 'Drug'
drugGroup = 'DrugGroup'
surgery = 'Surgery'
symptom = 'Symptom'

// ~~~~ Properties ~~~~
acute = 'acute'
applicationRoutes = 'applicationRoutes'
brandNames = 'brandNames'
chronic = 'chronic'
conditionName = 'conditionName'
docIds = 'docIds'
dosage = 'dosage'
drugGroupName = 'drugGroupName'
genericName = 'genericName'
precautions = 'precautions'
surgeryName = 'surgeryName'
symptomName = 'symptomName'
symptomType = 'symptomType'

// ~~~~ Edges ~~~~~
contraindicatedFor = 'CONTRAINDICATED_FOR'
hasSideEffect = 'HAS_SIDE_EFFECT'
hasSymptom = 'HAS_SYMPTOM'
inDrugGroup = 'IN_DRUG_GROUP'
treats = 'TREATS'

// ~~~~ Conditions ~~~~
alzheimers = g.addV(condition).
        property(conditionName, 'Alzheimer\'s Dementia').
        property(docIds, '1294929').
        next()

asthma = g.addV(condition).
        property(conditionName, 'Asthma').
        property(docIds, '94929').
        next()

diabetes = g.addV(condition).
        property(conditionName, 'Diabetes').
        property(docIds, '1234').
        property(docIds, '5678').
        next()

diabeticKetoacidosis = g.addV(condition).
        property(conditionName, 'Diabetic Ketoacidosis').
        property(docIds, '87874545649874').
        property(docIds, '12121212154548787').
        next()

glaucoma = g.addV(condition).
        property(conditionName, 'Acute angle closure Glaucoma').
        property(docIds, '1783478394').
        property(docIds, '290348023').
        next()

hyperglycemia = g.addV(condition).
        property(conditionName, 'Hyperglycemia').
        property(docIds, '210934523').
        next()

hypoglycemia = g.addV(condition).
        property(conditionName, 'Hypoglycemia').
        property(docIds, '0121').
        property(docIds, '0122').
        next()

// ~~~~ Drugs ~~~~
donepezil = g.addV(drug).
        property(genericName, 'donepezil').
        property(brandNames, 'Aricept').
        property(dosage, 'tablet\n 5mg\n 10mg\n 23mg\n tablet, oral disintegrating\n 5mg\n 10mg').
        property(applicationRoutes, 'oral').
        property(precautions, 'check with your doctor').
        next()

insulin = g.addV(drug).
        property(genericName, 'insulin regular human').
        property(brandNames, 'Humulin R').
        property(brandNames, 'Novolin R').
        property(brandNames, 'Humulin R U-500').
        property(dosage, 'Injectable solution\n\n    Over-the-counter (OTC)\n        100units/mL (3mL vial)\n        100units/mL (10mL vial)\n    Prescription (Rx)\n        500units/mL (20mL vial); prescribe with U-500 syringes to avoid conversion for U-100 tuberculin syringes\n        500units/mL (3mL pen)\n').
        property(dosage, 'Dosage Considerations – Should be Given as Follows:\n\nType 1 Diabetes Mellitus\n\nAdult\n\n    Initial: 0.2-0.4 units/kg/day subcutaneously (SC) divided every 8 hours or more frequently\n    Maintenance: 0.5-1 unit/kg/day subcutaneously (SC) divided every 8 hours or more frequently; in insulin-resistant patients (e.g., due to obesity), substantially higher daily insulin may be required\n    Approximately 50-75% of the total daily insulin requirements are given as intermediate- or long-acting insulin administered in 1-2 injections; rapid- or short-acting insulin should be used before or at mealtimes to satisfy the\n    remainder balance of the total daily insulin requirements\n    Premixed combinations are available that deliver rapid- or short-acting components at the same time as the intermediate- or long-acting component').
        property(precautions, 'Never share an insulin pen between patients even if needle is changed').
        property(precautions, 'Use with caution in patients with decreased insulin requirements: Diarrhea, nausea/vomiting, malabsorption, hypothyroidism, renal impairment, and hepatic impairment').
        property(precautions, 'Use with caution in patients with increased insulin requirements: Fever, hyperthyroidism, trauma, infection, and surgery').
        property(precautions, 'Rapid changes in serum glucose may induce symptoms of hypoglycemia; increase monitoring with changes to insulin dosage, co-administered glucose lowering medications, meal pattern, physical activity; and in patients with renal impairment or hepatic impairment or hypoglycemia unawareness').
        property(precautions, 'Hypoglycemia is the most common cause of adverse reactions (headache, tachycardia, etc.)').
        property(precautions, 'May cause a shift in potassium from extracellular to intracellular space, possibly leading to hypokalemia; caution when co-administered with potassium-lowering drugs or when administered to patients with a condition that may decrease potassium').
        property(precautions, 'Thiazolidinediones are peroxisome proliferator-activated receptor (PPAR)-gamma agonists and can cause dose-related fluid retention, particularly when used in combination with insulin; fluid retention may lead to or exacerbate heart failure; monitor for signs and symptoms of heart failure, treat the patient accordingly, and consider discontinuing thiazolidinediones').
        property(precautions, 'Change in insulin regimen should be carried out under close medical supervision and frequency of blood glucose monitoring should be increased').
        property(precautions, 'Severe, life-threatening, generalized allergy, including anaphylaxis, can occur; discontinue therapy if indicated').
        property(precautions, 'Not for mixing with any insulin for intravenous use or with insulins other than NPH insulin for subcutaneous use').
        property(precautions, 'Pregnancy').
        property(docIds, '0017').
        property(applicationRoutes, 'injection').
        next()

latanoprost = g.addV(drug).
        property(genericName, 'latanoprost').
        property(brandNames, 'Xalatan').
        property(docIds, '23564364').
        property(dosage, 'as needed, or as directed').
        property(applicationRoutes, 'opthalmic').
        property(precautions, 'follow instructions, and cease use if vision becomes worse').
        next()

linagliptin = g.addV(drug).
        property(genericName, 'linagliptin').
        property(brandNames, 'Tradjenta').
        property(applicationRoutes, 'oral').
        property(precautions, 'check with your doctor').
        property(dosage, 'as indicated by prescription or direction').
        property(docIds, '23452346346').
        next()

metformin = g.addV(drug).
        property(genericName, 'metformin').
        property(brandNames, 'Glucophage').
        property(dosage, '1-3 times daily with meals').
        property(applicationRoutes, 'Oral').
        property(docIds, '5353543').
        property(precautions, 'check with your doctor').
        next()

pramlintide = g.addV(drug).
        property(genericName, 'pramlintide').
        property(brandNames, 'Symlin Pen').
        property(applicationRoutes, 'injection').
        property(precautions, 'tell your doctor and pharmacist if you are allergic to pramlintide, any other medications, metacresol, or any other ingredients in the pramlintide pen. Ask your pharmacist or check the Medication Guide for a list of the ingredients.').
        property(docIds, '1232412').
        property(docIds, '12324244343').
        property(dosage, 'as indicated by instruction or prescription').
        next()

// ~~~~ Drug Groups ~~~~
antidiabetics = g.addV(drugGroup).
        property(drugGroupName, 'Antidiabetics').
        property(docIds, '0135').
        property(docIds, '0136').
        next()

antihyperglycemics = g.addV(drugGroup).
        property(drugGroupName, 'Antihyperglycemics').
        property(docIds, '123242452').
        next()

// ~~~~ Surgeries ~~~~
isletTransplant = g.addV(surgery).
        property(surgeryName, 'Islet transplant for Type 1 Diabetes').
        property(docIds, '0137').
        property(docIds, '0138').
        next()

// ~~~~ Symptoms ~~~~
abdominalPain = g.addV(symptom).
        property(symptomName, 'Abdominal pain').
        property(symptomType, chronic).
        property(docIds, '3365487').
        property(docIds, '798877882746').
        next()

allergy = g.addV(symptom).
        property(symptomName, 'Local allergic reaction').
        property(symptomType, acute).
        property(docIds, '0119').
        property(docIds, '0120').
        next()

backPain = g.addV(symptom).
        property(symptomName, 'Back pain').
        property(symptomType, acute).
        property(docIds, '0109').
        property(docIds, '0110').
        next()

bodyFatRedistribution = g.addV(symptom).
        property(symptomName, 'Body fat redistribution').
        property(symptomType, acute).
        property(docIds, '0115').
        property(docIds, '0116').
        next()

breathlessness = g.addV(symptom).
        property(symptomName, 'Breathlessness').
        property(symptomType, acute).
        property(docIds, '234235235423532').
        next()

coma = g.addV(symptom).
        property(symptomName, 'coma').
        property(symptomType, chronic).
        property(docIds, '46401304456').
        property(docIds, '7680988986').
        next()

concentration = g.addV(symptom).
        property(symptomName, 'Trouble concentrating').
        property(symptomType, acute).
        property(docIds, '0127').
        property(docIds, '0128').
        next()

confusion = g.addV(symptom).
        property(symptomName, 'Confusion').
        property(symptomType, chronic).
        property(docIds, '013090931').
        property(docIds, '0878781314').
        next()

constipation = g.addV(symptom).
        property(symptomName, 'Constipation').
        property(symptomType, acute).
        property(docIds, '23434349').
        next()

cough = g.addV(symptom).
        property(symptomName, 'Cough').
        property(symptomType, chronic).
        property(docIds, '234233').
        property(docIds, '534626').
        next()

diarrhea = g.addV(symptom).
        property(symptomName, 'Diarrhea').
        property(symptomType, acute).
        property(docIds, '0107').
        property(docIds, '0108').
        next()

difficultyBreathing = g.addV(symptom).
        property(symptomName, 'Difficulty breathing').
        property(symptomType, chronic).
        property(docIds, '464013087979').
        property(docIds, '768087879087').
        next()

difficultySwallowing = g.addV(symptom).
        property(symptomName, 'Difficulty swallowing').
        property(symptomType, chronic).
        property(docIds, '4640130909098').
        property(docIds, '768087082746').
        next()

difficultyWithFamiliarTasks = g.addV(symptom).
        property(symptomName, 'Difficulty Completing Familiar Tasks').
        property(symptomType, chronic).
        property(docIds, '1232411').
        next()

dizziness = g.addV(symptom).
        property(symptomName, 'Dizziness').
        property(symptomType, acute).
        property(docIds, '98978986').
        next()

dryMouth = g.addV(symptom).
        property(symptomName, 'Dry mouth').
        property(symptomType, chronic).
        property(docIds, '464534').
        property(docIds, '065782746').
        next()

eyePain = g.addV(symptom).
        property(symptomName, 'Eye Pain').
        property(symptomType, chronic).
        property(docIds, '016765733').
        property(docIds, '01334344').
        next()

eyeRedness = g.addV(symptom).
        property(symptomName, 'Eye Redness').
        property(symptomType, chronic).
        property(docIds, '01309093').
        property(docIds, '087878134').
        next()

fainting = g.addV(symptom).
        property(symptomName, 'Fainting').
        property(symptomType, acute).
        property(docIds, '0131').
        property(docIds, '0132').
        next()

fatigue = g.addV(symptom).
        property(symptomName, 'Fatigue').
        property(symptomType, chronic).
        property(docIds, '0011').
        property(docIds, '0012').
        next()

fruityBreath = g.addV(symptom).
        property(symptomName, 'Fruity smelling breath').
        property(symptomType, chronic).
        property(docIds, '46401309093').
        property(docIds, '768087878134').
        next()

headache = g.addV(symptom).
        property(symptomName, 'Headache').
        property(symptomType, acute).
        property(docIds, '0101').
        property(docIds, '0102').
        next()

hives = g.addV(symptom).
        property(symptomName, 'Hives').
        property(symptomType, acute).
        property(docIds, '1152135123521315').
        property(docIds, '954086').
        next()

hunger = g.addV(symptom).
        property(symptomName, 'Extreme hunger').
        property(symptomType, acute).
        property(docIds, '0005').
        property(docIds, '0006').
        next()

indigestion = g.addV(symptom).
        property(symptomName, 'Indigestion').
        property(symptomType, acute).
        property(docIds, '0105').
        property(docIds, '0106').
        next()

injectionSiteReaction = g.addV(symptom).
        property(symptomName, 'Injection site reaction').
        property(symptomType, acute).
        property(docIds, '0103').
        property(docIds, '0104').
        next()

insulinResistance = g.addV(symptom).
        property(symptomName, 'Insulin resistance').
        property(symptomType, acute).
        property(docIds, '0113').
        property(docIds, '0114').
        next()

irritability = g.addV(symptom).
        property(symptomName, 'Irritability').
        property(symptomType, acute).
        property(docIds, '0013').
        property(docIds, '0014').
        next()

itchingOrFlakingSkin = g.addV(symptom).
        property(symptomName, 'Itching, flaking, or peeling skin').
        property(symptomType, chronic).
        property(docIds, '3254453454').
        property(docIds, '584796841').
        next()

jointPain = g.addV(symptom).
        property(symptomName, 'Joint Pain').
        property(symptomType, chronic).
        property(docIds, '0123133').
        property(docIds, '01453534').
        next()

ketones = g.addV(symptom).
        property(symptomName, 'Presence of ketones in urine').
        property(symptomType, acute).
        property(docIds, '0009').
        property(docIds, '0010').
        next()

lossOfAppetite = g.addV(symptom).
        property(symptomName, 'Loss of Appetite').
        property(symptomType, chronic).
        property(docIds, '0133').
        property(docIds, '0134').
        next()

memoryLoss = g.addV(symptom).
        property(symptomName, 'Memory Loss').
        property(symptomType, chronic).
        property(docIds, '21412').
        next()

metallicTasteInMouth = g.addV(symptom).
        property(symptomName, 'Metallic taste in mouth').
        property(symptomType, chronic).
        property(docIds, '01309093').
        property(docIds, '087878134').
        next()

misplacingThings = g.addV(symptom).
        property(symptomName, 'Misplacing Things').
        property(symptomType, chronic).
        property(docIds, '8394050').
        next()

moodAndPersonalityChange = g.addV(symptom).
        property(symptomName, 'Changes in Mood or Personality').
        property(symptomType, chronic).
        property(docIds, '103985').
        next()

nausea = g.addV(symptom).
        property(symptomName, 'Nausea').
        property(symptomType, chronic).
        property(docIds, '013663').
        property(docIds, '0167834').
        next()

poorJudgment = g.addV(symptom).
        property(symptomName, 'Poor Judgment').
        property(symptomType, chronic).
        property(docIds, '123240098').
        next()

problemSolving = g.addV(symptom).
        property(symptomName, 'Difficulty Problem Solving').
        property(symptomType, chronic).
        property(docIds, '239492').
        next()

rapidBreathing = g.addV(symptom).
        property(symptomName, 'Rapid breathing').
        property(symptomType, acute).
        property(docIds, '0129').
        property(docIds, '0130').
        next()

rash = g.addV(symptom).
        property(symptomName, 'Rash').
        property(symptomType, acute).
        property(docIds, '46401346457409093').
        property(docIds, '7680887977878134').
        next()

seizures = g.addV(symptom).
        property(symptomName, 'Seizures').
        property(symptomType, acute).
        property(docIds, '0133').
        property(docIds, '0134').
        next()

shortnessOfBreath = g.addV(symptom).
        property(symptomName, 'Shortness of breath').
        property(symptomType, acute).
        property(docIds, '4640653439098').
        property(docIds, '768087074').
        next()

socialWithdrawal = g.addV(symptom).
        property(symptomName, 'Withdrawal from Work and Social Activities').
        property(symptomType, chronic).
        property(docIds, '1239495').
        next()

soreThroat = g.addV(symptom).
        property(symptomName, 'Sore throat').
        property(symptomType, acute).
        property(docIds, '0111').
        property(docIds, '0112').
        next()

spatialAwareness = g.addV(symptom).
        property(symptomName, 'Trouble Understanding Visual Images and Spatial Relationships').
        property(symptomType, chronic).
        property(docIds, '123245976').
        next()

speakingAndWriting = g.addV(symptom).
        property(symptomName, 'Problems Speaking or Writing').
        property(symptomType, chronic).
        property(docIds, '875874').
        next()

stomachPain = g.addV(symptom).
        property(symptomName, 'Stomach Pain').
        property(symptomType, chronic).
        property(docIds, '65763544811').
        property(docIds, '576841681681').
        next()

subQ = g.addV(symptom).
        property(symptomName, 'Abnormal accumulation of fat underneath the surface of the skin').
        property(symptomType, acute).
        property(docIds, '0117').
        property(docIds, '0118').
        next()

swelling = g.addV(symptom).
        property(symptomName, 'Swelling of the face, lips, tongue, or throat').
        property(symptomType, chronic).
        property(docIds, '464043562').
        property(docIds, '790980134').
        next()

thirst = g.addV(symptom).
        property(symptomName, 'Increased thirst').
        property(symptomType, acute).
        property(docIds, '0001').
        property(docIds, '0002').
        next()

tightChest = g.addV(symptom).
        property(symptomName, 'Tight Chest').
        property(symptomType, acute).
        property(docIds, '97483').
        next()

tremors = g.addV(symptom).
        property(symptomName, 'Tremors').
        property(symptomType, acute).
        property(docIds, '0125').
        property(docIds, '0126').
        next()

upsetStomach = g.addV(symptom).
        property(symptomName, 'Upset Stomach').
        property(symptomType, acute).
        property(docIds, '48484542425').
        property(docIds, '98748643').
        next()

urine = g.addV(symptom).
        property(symptomName, 'Frequent urination').
        property(symptomType, acute).
        property(docIds, '0003').
        property(docIds, '0004').
        next()

vision = g.addV(symptom).
        property(symptomName, 'Blurred Vision').
        property(symptomType, acute).
        property(docIds, '0015').
        property(docIds, '0016').
        next()

visualHalos = g.addV(symptom).
        property(symptomName, 'Visual Halos').
        property(symptomType, chronic).
        property(docIds, '0176867833').
        property(docIds, '01877634').
        next()

vomiting = g.addV(symptom).
        property(symptomName, 'Vomiting').
        property(symptomType, chronic).
        property(docIds, '654654684518').
        property(docIds, '98756435').
        next()

weakness = g.addV(symptom).
        property(symptomName, 'Weakness').
        property(symptomType, acute).
        property(docIds, '0123').
        property(docIds, '0124').
        next()

weightLoss = g.addV(symptom).
        property(symptomName, 'Unexplained weight loss').
        property(symptomType, chronic).
        property(docIds, '0007').
        property(docIds, '0008').
        next()

wheezing = g.addV(symptom).
        property(symptomName, 'Wheezing').
        property(symptomType, acute).
        property(docIds, '0349593').
        next()

// EDGES --------------------------------------------------------

// ~~~~ Condition Has Symptom ~~~
alzheimers.addEdge(hasSymptom, confusion)
alzheimers.addEdge(hasSymptom, difficultyWithFamiliarTasks)
alzheimers.addEdge(hasSymptom, memoryLoss)
alzheimers.addEdge(hasSymptom, misplacingThings)
alzheimers.addEdge(hasSymptom, moodAndPersonalityChange)
alzheimers.addEdge(hasSymptom, poorJudgment)
alzheimers.addEdge(hasSymptom, problemSolving)
alzheimers.addEdge(hasSymptom, socialWithdrawal)
alzheimers.addEdge(hasSymptom, spatialAwareness)
alzheimers.addEdge(hasSymptom, speakingAndWriting)

asthma.addEdge(hasSymptom, breathlessness)
asthma.addEdge(hasSymptom, cough)
asthma.addEdge(hasSymptom, tightChest)
asthma.addEdge(hasSymptom, wheezing)

diabetes.addEdge(hasSymptom, fatigue)
diabetes.addEdge(hasSymptom, hunger)
diabetes.addEdge(hasSymptom, irritability)
diabetes.addEdge(hasSymptom, ketones)
diabetes.addEdge(hasSymptom, thirst)
diabetes.addEdge(hasSymptom, urine)
diabetes.addEdge(hasSymptom, vision)
diabetes.addEdge(hasSymptom, weightLoss)

diabeticKetoacidosis.addEdge(hasSymptom, confusion)
diabeticKetoacidosis.addEdge(hasSymptom, fatigue)
diabeticKetoacidosis.addEdge(hasSymptom, fruityBreath)
diabeticKetoacidosis.addEdge(hasSymptom, ketones)
diabeticKetoacidosis.addEdge(hasSymptom, nausea)
diabeticKetoacidosis.addEdge(hasSymptom, stomachPain)
diabeticKetoacidosis.addEdge(hasSymptom, thirst)
diabeticKetoacidosis.addEdge(hasSymptom, urine)
diabeticKetoacidosis.addEdge(hasSymptom, vomiting)

glaucoma.addEdge(hasSymptom, eyePain)
glaucoma.addEdge(hasSymptom, eyeRedness)
glaucoma.addEdge(hasSymptom, headache)
glaucoma.addEdge(hasSymptom, nausea)
glaucoma.addEdge(hasSymptom, vision)
glaucoma.addEdge(hasSymptom, visualHalos)

hyperglycemia.addEdge(hasSymptom, abdominalPain)
hyperglycemia.addEdge(hasSymptom, coma)
hyperglycemia.addEdge(hasSymptom, confusion)
hyperglycemia.addEdge(hasSymptom, dryMouth)
hyperglycemia.addEdge(hasSymptom, fruityBreath)
hyperglycemia.addEdge(hasSymptom, nausea)
hyperglycemia.addEdge(hasSymptom, shortnessOfBreath)
hyperglycemia.addEdge(hasSymptom, vomiting)
hyperglycemia.addEdge(hasSymptom, weakness)

hypoglycemia.addEdge(hasSymptom, concentration)
hypoglycemia.addEdge(hasSymptom, fainting)
hypoglycemia.addEdge(hasSymptom, headache)
hypoglycemia.addEdge(hasSymptom, hunger)
hypoglycemia.addEdge(hasSymptom, irritability)
hypoglycemia.addEdge(hasSymptom, seizures)
hypoglycemia.addEdge(hasSymptom, tremors)
hypoglycemia.addEdge(hasSymptom, rapidBreathing)
hypoglycemia.addEdge(hasSymptom, weakness)

// ~~~~ Condition Has Symptom Other Condition
diabetes.addEdge(hasSymptom, hyperglycemia)

// ~~~~ Drug Treats Condition ~~~~
donepezil.addEdge(treats, alzheimers)
insulin.addEdge(treats, diabetes)
latanoprost.addEdge(treats, glaucoma)
linagliptin.addEdge(treats, diabetes)
metformin.addEdge(treats, diabetes)
pramlintide.addEdge(treats, diabetes)

// ~~~~ Drug Has Side Effect Symptom ~~~~
donepezil.addEdge(hasSideEffect, confusion)
donepezil.addEdge(hasSideEffect, constipation)
donepezil.addEdge(hasSideEffect, dizziness)
donepezil.addEdge(hasSideEffect, headache)

insulin.addEdge(hasSideEffect, allergy)
insulin.addEdge(hasSideEffect, backPain)
insulin.addEdge(hasSideEffect, bodyFatRedistribution)
insulin.addEdge(hasSideEffect, diarrhea)
insulin.addEdge(hasSideEffect, headache)
insulin.addEdge(hasSideEffect, indigestion)
insulin.addEdge(hasSideEffect, injectionSiteReaction)
insulin.addEdge(hasSideEffect, insulinResistance)
insulin.addEdge(hasSideEffect, soreThroat)
insulin.addEdge(hasSideEffect, subQ)

latanoprost.addEdge(hasSideEffect, eyeRedness)
latanoprost.addEdge(hasSideEffect, vision)

linagliptin.addEdge(hasSideEffect, difficultyBreathing)
linagliptin.addEdge(hasSideEffect, difficultySwallowing)
linagliptin.addEdge(hasSideEffect, headache)
linagliptin.addEdge(hasSideEffect, hives)
linagliptin.addEdge(hasSideEffect, itchingOrFlakingSkin)
linagliptin.addEdge(hasSideEffect, jointPain)
linagliptin.addEdge(hasSideEffect, lossOfAppetite)
linagliptin.addEdge(hasSideEffect, nausea)
linagliptin.addEdge(hasSideEffect, rash)
linagliptin.addEdge(hasSideEffect, swelling)

metformin.addEdge(hasSideEffect, diarrhea)
metformin.addEdge(hasSideEffect, metallicTasteInMouth)
metformin.addEdge(hasSideEffect, nausea)
metformin.addEdge(hasSideEffect, upsetStomach)
metformin.addEdge(hasSideEffect, vomiting)

pramlintide.addEdge(hasSideEffect, cough)
pramlintide.addEdge(hasSideEffect, fatigue)
pramlintide.addEdge(hasSideEffect, jointPain)
pramlintide.addEdge(hasSideEffect, lossOfAppetite)
pramlintide.addEdge(hasSideEffect, soreThroat)

// ~~~~ Drug Has Side Effect Condition ~~~~
insulin.addEdge(hasSideEffect, hypoglycemia)
pramlintide.addEdge(hasSideEffect, hypoglycemia)

// ~~~~ Drug In Drug Group ~~~~
insulin.addEdge(inDrugGroup, antidiabetics)
pramlintide.addEdge(inDrugGroup, antihyperglycemics)

// ~~~~ Drug Contraindicated For Condition ~~~~
donepezil.addEdge(contraindicatedFor, asthma)
insulin.addEdge(contraindicatedFor, hypoglycemia)
metformin.addEdge(contraindicatedFor, antidiabetics)
metformin.addEdge(contraindicatedFor, diabeticKetoacidosis)

// ~~~~ Surgery Treats Condition ~~~~
isletTransplant.addEdge(treats, diabetes)

// END
tx.commit()
