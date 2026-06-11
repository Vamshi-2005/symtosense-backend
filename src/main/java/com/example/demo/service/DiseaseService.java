package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DiseaseService {

    public Map<String, String> getDiseaseDetails(String name) {
        Map<String, String> data = new LinkedHashMap<>();

        switch (name.toLowerCase().replace(" ", "_")) {

            case "flu":
                data.put("description", "Influenza is a contagious respiratory illness caused by influenza viruses.");
                data.put("symptoms", "Fever, cough, sore throat, runny nose, body aches, headache, chills, fatigue");
                data.put("causes", "Influenza A or B viruses, transmitted via respiratory droplets");
                data.put("precautions", "Annual flu vaccine, frequent handwashing, avoid close contact with sick people");
                data.put("medicines", "Oseltamivir (Tamiflu), Zanamivir, Paracetamol for fever");
                data.put("severity", "Moderate");
                data.put("icon", "🤧");
                break;

            case "covid19":
                data.put("description", "A respiratory illness caused by SARS-CoV-2 virus, ranging from mild to severe.");
                data.put("symptoms", "Fever, cough, fatigue, loss of smell/taste, shortness of breath, body ache");
                data.put("causes", "SARS-CoV-2 coronavirus, spreads via respiratory droplets and aerosols");
                data.put("precautions", "Vaccination, wear masks, physical distancing, proper ventilation, hand hygiene");
                data.put("medicines", "Paxlovid, Remdesivir, corticosteroids for severe cases, supportive care");
                data.put("severity", "High");
                data.put("icon", "😷");
                break;

            case "pneumonia":
                data.put("description", "Infection inflaming the air sacs in one or both lungs, filling them with fluid.");
                data.put("symptoms", "Fever, cough with phlegm, shortness of breath, chest pain, fatigue");
                data.put("causes", "Bacteria (Streptococcus pneumoniae), viruses, fungi");
                data.put("precautions", "Vaccination, good hygiene, avoid smoking, treat respiratory infections promptly");
                data.put("medicines", "Antibiotics (Amoxicillin), antiviral drugs, oxygen therapy if severe");
                data.put("severity", "High");
                data.put("icon", "🫁");
                break;

            case "bronchitis":
                data.put("description", "Inflammation of the bronchial tubes causing persistent cough and mucus.");
                data.put("symptoms", "Persistent cough, shortness of breath, chest discomfort, mucus production");
                data.put("causes", "Viruses (most common), bacteria, cigarette smoke, air pollution");
                data.put("precautions", "Quit smoking, avoid lung irritants, use air purifiers, get flu vaccine");
                data.put("medicines", "Bronchodilators, cough suppressants, antibiotics if bacterial");
                data.put("severity", "Moderate");
                data.put("icon", "💨");
                break;

            case "asthma":
                data.put("description", "A chronic condition causing airways to narrow and swell, making breathing difficult.");
                data.put("symptoms", "Shortness of breath, wheezing cough, chest tightness, dizziness, fatigue");
                data.put("causes", "Allergens, air pollution, respiratory infections, exercise, stress, cold air");
                data.put("precautions", "Avoid triggers, use air purifiers, take prescribed medications, monitor peak flow");
                data.put("medicines", "Salbutamol inhaler, Corticosteroid inhalers, Leukotriene modifiers");
                data.put("severity", "High");
                data.put("icon", "💨");
                break;

            case "migraine":
                data.put("description", "A neurological condition causing intense, debilitating headaches often with nausea.");
                data.put("symptoms", "Severe headache, nausea, dizziness, sensitivity to light and sound");
                data.put("causes", "Genetic factors, hormonal changes, stress, certain foods or drinks, sleep disruption");
                data.put("precautions", "Identify and avoid triggers, maintain regular sleep schedule, manage stress");
                data.put("medicines", "Sumatriptan, Ibuprofen, Aspirin, anti-nausea medications");
                data.put("severity", "Moderate");
                data.put("icon", "🧠");
                break;

            case "meningitis":
                data.put("description", "Inflammation of the membranes surrounding the brain and spinal cord, often caused by infection.");
                data.put("symptoms", "Severe headache, neck stiffness, high fever, vomiting, sensitivity to light");
                data.put("causes", "Bacterial (Neisseria meningitidis), viral infections, fungi");
                data.put("precautions", "Meningococcal vaccine, avoid close contact with infected persons, good hygiene");
                data.put("medicines", "Antibiotics (Penicillin, Cefotaxime), corticosteroids, antiviral if viral");
                data.put("severity", "Critical");
                data.put("icon", "🧬");
                break;

            case "gastroenteritis":
                data.put("description", "Inflammation of the stomach and intestines, commonly called stomach flu.");
                data.put("symptoms", "Vomiting, diarrhea, nausea, stomach cramps, fever");
                data.put("causes", "Norovirus, rotavirus, bacteria (E. coli, Salmonella), contaminated food/water");
                data.put("precautions", "Proper hand hygiene, safe food handling, drink clean water, stay hydrated");
                data.put("medicines", "Oral rehydration salts (ORS), antiemetics, probiotics");
                data.put("severity", "Moderate");
                data.put("icon", "🤢");
                break;

            case "food_poisoning":
                data.put("description", "Illness caused by eating contaminated food containing bacteria, viruses or toxins.");
                data.put("symptoms", "Nausea, vomiting, diarrhea, stomach cramps, fever");
                data.put("causes", "Salmonella, E. coli, Listeria, Staphylococcus, improperly stored/cooked food");
                data.put("precautions", "Cook food thoroughly, refrigerate properly, avoid raw/undercooked meat");
                data.put("medicines", "ORS for hydration, antibiotics if bacterial, anti-nausea medicine");
                data.put("severity", "Moderate");
                data.put("icon", "🍽️");
                break;

            case "cholera":
                data.put("description", "An acute diarrheal infection caused by ingesting contaminated water or food.");
                data.put("symptoms", "Profuse watery diarrhea, vomiting, nausea, muscle cramps, dehydration");
                data.put("causes", "Vibrio cholerae bacterium in contaminated water or food");
                data.put("precautions", "Drink safe water, proper sanitation, oral cholera vaccine, wash hands");
                data.put("medicines", "Oral rehydration salts, IV fluids, Doxycycline, Azithromycin");
                data.put("severity", "High");
                data.put("icon", "💧");
                break;

            case "typhoid":
                data.put("description", "A bacterial infection caused by Salmonella typhi, spread through contaminated food/water.");
                data.put("symptoms", "Prolonged fever, headache, rash, sweating, fatigue, loss of appetite");
                data.put("causes", "Salmonella enterica serotype Typhi via fecal-oral transmission");
                data.put("precautions", "Typhoid vaccine, safe drinking water, proper hand hygiene, avoid street food");
                data.put("medicines", "Ciprofloxacin, Azithromycin, Ceftriaxone, Chloramphenicol");
                data.put("severity", "High");
                data.put("icon", "🦠");
                break;

            case "malaria":
                data.put("description", "A life-threatening disease caused by Plasmodium parasites transmitted by mosquitoes.");
                data.put("symptoms", "High fever, chills, sweating, body aches, joint pain, fatigue, nausea");
                data.put("causes", "Plasmodium parasites (P. falciparum, P. vivax) via Anopheles mosquito bites");
                data.put("precautions", "Use mosquito nets, insect repellent, antimalarial drugs when traveling");
                data.put("medicines", "Artemisinin-based therapy, Chloroquine, Quinine, Primaquine");
                data.put("severity", "High");
                data.put("icon", "🦟");
                break;

            case "dengue":
                data.put("description", "A viral infection spread by Aedes mosquitoes causing severe flu-like illness.");
                data.put("symptoms", "High fever, severe headache, joint/muscle pain, rash, eye redness, fatigue");
                data.put("causes", "Dengue virus (DENV 1-4) transmitted by Aedes aegypti mosquitoes");
                data.put("precautions", "Eliminate standing water, use mosquito repellents, wear protective clothing");
                data.put("medicines", "Paracetamol for fever, IV fluids, rest, avoid aspirin/ibuprofen");
                data.put("severity", "High");
                data.put("icon", "🌡️");
                break;

            case "hepatitis":
                data.put("description", "Inflammation of the liver, usually caused by a viral infection.");
                data.put("symptoms", "Jaundice, fatigue, nausea, vomiting, loss of appetite, abdominal pain");
                data.put("causes", "Hepatitis A, B, C, D, E viruses; alcohol, toxins, autoimmune conditions");
                data.put("precautions", "Vaccination (Hep A & B), safe sex, no needle sharing, avoid excess alcohol");
                data.put("medicines", "Antiviral drugs (Tenofovir, Entecavir), Interferon, supportive care");
                data.put("severity", "High");
                data.put("icon", "🫀");
                break;

            case "tonsillitis":
                data.put("description", "Inflammation of the tonsils, causing sore throat and difficulty swallowing.");
                data.put("symptoms", "Sore throat, swollen lymph nodes, ear pain, difficulty swallowing, fever");
                data.put("causes", "Streptococcal bacteria, viral infections (Epstein-Barr, adenovirus)");
                data.put("precautions", "Avoid sharing utensils, wash hands frequently, avoid close contact with infected");
                data.put("medicines", "Antibiotics (Penicillin), pain relievers, throat lozenges");
                data.put("severity", "Low");
                data.put("icon", "👅");
                break;

            case "sinusitis":
                data.put("description", "Inflammation of the sinuses causing nasal congestion and facial pressure.");
                data.put("symptoms", "Headache, runny nose, ear pain, sneezing, facial pressure, fatigue");
                data.put("causes", "Viral infections, bacterial infections, allergies, nasal polyps");
                data.put("precautions", "Avoid allergens, use humidifier, nasal irrigation, stay hydrated");
                data.put("medicines", "Decongestants, antihistamines, nasal corticosteroids, antibiotics if bacterial");
                data.put("severity", "Low");
                data.put("icon", "👃");
                break;

            case "arthritis":
                data.put("description", "Inflammation of one or more joints causing pain and stiffness.");
                data.put("symptoms", "Joint pain, stiffness, back pain, fatigue, swelling, reduced range of motion");
                data.put("causes", "Autoimmune (rheumatoid), wear-and-tear (osteoarthritis), gout, infection");
                data.put("precautions", "Regular gentle exercise, maintain healthy weight, joint protection techniques");
                data.put("medicines", "NSAIDs, DMARDs, Corticosteroids, Biologics, Physical therapy");
                data.put("severity", "Moderate");
                data.put("icon", "🦴");
                break;

            case "hypertension":
                data.put("description", "High blood pressure — a chronic condition where blood pressure is persistently elevated.");
                data.put("symptoms", "Headache, dizziness, chest pain, palpitations, vision blurred, sweating");
                data.put("causes", "Genetics, obesity, high salt diet, stress, sedentary lifestyle, kidney disease");
                data.put("precautions", "Reduce salt intake, exercise regularly, maintain healthy weight, limit alcohol");
                data.put("medicines", "ACE inhibitors, Beta-blockers, Calcium channel blockers, Diuretics");
                data.put("severity", "High");
                data.put("icon", "❤️");
                break;

            case "heart_disease":
                data.put("description", "A range of conditions affecting the heart including coronary artery disease and arrhythmias.");
                data.put("symptoms", "Chest pain, palpitations, shortness of breath, fatigue, dizziness, sweating");
                data.put("causes", "High blood pressure, high cholesterol, smoking, diabetes, family history, obesity");
                data.put("precautions", "Heart-healthy diet, regular exercise, no smoking, stress management, regular checkups");
                data.put("medicines", "Statins, Beta-blockers, Aspirin, ACE inhibitors, Nitroglycerin");
                data.put("severity", "Critical");
                data.put("icon", "💔");
                break;

            case "anemia":
                data.put("description", "A condition where the blood lacks enough healthy red blood cells to carry oxygen.");
                data.put("symptoms", "Fatigue, dizziness, hair loss, weight loss, shortness of breath, palpitations");
                data.put("causes", "Iron deficiency, vitamin B12 deficiency, blood loss, chronic disease");
                data.put("precautions", "Iron-rich diet (spinach, meat), vitamin C for absorption, treat underlying cause");
                data.put("medicines", "Iron supplements, Vitamin B12 injections, Folic acid, Erythropoietin");
                data.put("severity", "Moderate");
                data.put("icon", "🩸");
                break;

            case "diabetes":
                data.put("description", "A chronic condition that affects how the body processes blood sugar (glucose).");
                data.put("symptoms", "Frequent urination, weight loss, fatigue, vision blurred, itching, dizziness");
                data.put("causes", "Insulin deficiency or resistance, genetics, obesity, sedentary lifestyle");
                data.put("precautions", "Healthy diet, regular exercise, monitor blood sugar, maintain healthy weight");
                data.put("medicines", "Metformin, Insulin therapy, SGLT2 inhibitors, GLP-1 receptor agonists");
                data.put("severity", "High");
                data.put("icon", "💉");
                break;

            case "uti":
                data.put("description", "A urinary tract infection affecting any part of the urinary system.");
                data.put("symptoms", "Painful urination, frequent urination, abdominal pain, fever, fatigue");
                data.put("causes", "E. coli bacteria, Staphylococcus, poor hygiene, sexual activity, dehydration");
                data.put("precautions", "Stay hydrated, urinate after intercourse, wipe front to back, avoid irritants");
                data.put("medicines", "Antibiotics (Trimethoprim, Nitrofurantoin, Ciprofloxacin), pain relievers");
                data.put("severity", "Moderate");
                data.put("icon", "🚽");
                break;

            case "kidney_disease":
                data.put("description", "Gradual loss of kidney function over time, affecting waste filtration from blood.");
                data.put("symptoms", "Back pain, frequent urination, fatigue, nausea, swollen lymph nodes, dizziness");
                data.put("causes", "Diabetes, hypertension, glomerulonephritis, recurrent kidney infections");
                data.put("precautions", "Control blood pressure, manage diabetes, stay hydrated, avoid NSAIDs long-term");
                data.put("medicines", "ACE inhibitors, diuretics, phosphate binders, erythropoietin, dialysis if severe");
                data.put("severity", "High");
                data.put("icon", "🫘");
                break;

            case "thyroid":
                data.put("description", "A disorder of the thyroid gland affecting metabolism, energy and mood.");
                data.put("symptoms", "Weight gain, fatigue, hair loss, anxiety, palpitations, constipation, sweating");
                data.put("causes", "Autoimmune disease (Hashimoto's), iodine deficiency, thyroid nodules, radiation");
                data.put("precautions", "Regular thyroid checks, iodine-rich diet, stress management, avoid goitrogens");
                data.put("medicines", "Levothyroxine (hypothyroid), Methimazole (hyperthyroid), radioactive iodine");
                data.put("severity", "Moderate");
                data.put("icon", "🦋");
                break;

            case "chicken_pox":
                data.put("description", "A highly contagious viral infection causing an itchy blister-like rash.");
                data.put("symptoms", "Itchy rash, fever, fatigue, loss of appetite, headache, skin peeling");
                data.put("causes", "Varicella-zoster virus, spreads through direct contact or airborne droplets");
                data.put("precautions", "Varicella vaccine, avoid contact with infected persons, don't scratch blisters");
                data.put("medicines", "Acyclovir (antiviral), calamine lotion, antihistamines, paracetamol for fever");
                data.put("severity", "Moderate");
                data.put("icon", "🔴");
                break;

            case "measles":
                data.put("description", "A highly contagious viral disease causing fever, cough and a distinctive red rash.");
                data.put("symptoms", "Rash, high fever, runny nose, cough, eye redness, sneezing, swollen lymph nodes");
                data.put("causes", "Measles virus (Paramyxovirus), spreads through respiratory droplets");
                data.put("precautions", "MMR vaccine, isolate infected persons, vitamin A supplementation");
                data.put("medicines", "Vitamin A supplements, antipyretics, rest, fluids, antibiotics if complications");
                data.put("severity", "High");
                data.put("icon", "🔵");
                break;

            case "malnutrition":
                data.put("description", "A condition resulting from insufficient intake of nutrients needed for health.");
                data.put("symptoms", "Weight loss, hair loss, fatigue, bloating, muscle cramps, dizziness, constipation");
                data.put("causes", "Inadequate food intake, poor diet quality, malabsorption disorders, poverty");
                data.put("precautions", "Balanced diet, regular meals, nutritional supplements, treat underlying conditions");
                data.put("medicines", "Vitamin and mineral supplements, therapeutic food (RUTF), treat infections");
                data.put("severity", "High");
                data.put("icon", "🥗");
                break;

            case "appendicitis":
                data.put("description", "Inflammation of the appendix causing severe abdominal pain requiring urgent treatment.");
                data.put("symptoms", "Severe abdominal pain, nausea, fever, vomiting, loss of appetite, bloating");
                data.put("causes", "Blockage of appendix by stool, foreign body, or infection");
                data.put("precautions", "Seek immediate medical attention, high-fiber diet may reduce risk");
                data.put("medicines", "Antibiotics, surgical removal (appendectomy), pain management");
                data.put("severity", "Critical");
                data.put("icon", "⚠️");
                break;

            case "conjunctivitis":
                data.put("description", "Inflammation of the conjunctiva causing red, itchy, watery eyes (pink eye).");
                data.put("symptoms", "Eye redness, itching, sneezing, runny nose, headache, fatigue");
                data.put("causes", "Viral (adenovirus), bacterial, allergic reactions, chemical exposure");
                data.put("precautions", "Wash hands frequently, avoid touching eyes, don't share towels or eye drops");
                data.put("medicines", "Antibiotic eye drops (bacterial), antihistamine drops (allergic), lubricating drops");
                data.put("severity", "Low");
                data.put("icon", "👁️");
                break;

            case "ear_infection":
                data.put("description", "An infection of the middle ear, commonly affecting children but also adults.");
                data.put("symptoms", "Ear pain, fever, headache, fatigue, nausea, dizziness");
                data.put("causes", "Bacteria (Streptococcus, Haemophilus), viruses, cold or respiratory infections");
                data.put("precautions", "Treat colds promptly, avoid smoke, breastfeed infants, pneumococcal vaccine");
                data.put("medicines", "Antibiotics (Amoxicillin), pain relievers, warm compress, decongestants");
                data.put("severity", "Low");
                data.put("icon", "👂");
                break;

            default:
                data.put("description", "A medical condition requiring professional evaluation.");
                data.put("symptoms", "Varies by condition");
                data.put("causes", "Multiple possible causes");
                data.put("precautions", "Consult a qualified healthcare professional");
                data.put("medicines", "As prescribed by your doctor");
                data.put("severity", "Unknown");
                data.put("icon", "🏥");
        }
        return data;
    }

    public Map<String, String> getSpecialist(String disease) {
        Map<String, String> info = new LinkedHashMap<>();

        switch (disease.toLowerCase().replace(" ", "_")) {
            case "flu": case "covid19": case "bronchitis": case "pneumonia":
                info.put("specialist", "Pulmonologist / General Physician");
                info.put("icon", "🫁");
                info.put("search", "pulmonologist near me");
                break;
            case "asthma":
                info.put("specialist", "Pulmonologist / Allergist");
                info.put("icon", "💨");
                info.put("search", "pulmonologist near me");
                break;
            case "migraine": case "meningitis":
                info.put("specialist", "Neurologist");
                info.put("icon", "🧠");
                info.put("search", "neurologist near me");
                break;
            case "gastroenteritis": case "food_poisoning": case "cholera":
            case "appendicitis": case "hepatitis":
                info.put("specialist", "Gastroenterologist");
                info.put("icon", "🫃");
                info.put("search", "gastroenterologist near me");
                break;
            case "typhoid": case "malaria": case "dengue": case "measles":
            case "chicken_pox":
                info.put("specialist", "Infectious Disease Specialist");
                info.put("icon", "🦠");
                info.put("search", "infectious disease doctor near me");
                break;
            case "hypertension": case "heart_disease":
                info.put("specialist", "Cardiologist");
                info.put("icon", "❤️");
                info.put("search", "cardiologist near me");
                break;
            case "arthritis":
                info.put("specialist", "Rheumatologist / Orthopedic");
                info.put("icon", "🦴");
                info.put("search", "rheumatologist near me");
                break;
            case "diabetes": case "thyroid":
                info.put("specialist", "Endocrinologist");
                info.put("icon", "💉");
                info.put("search", "endocrinologist near me");
                break;
            case "anemia": case "malnutrition":
                info.put("specialist", "Hematologist / General Physician");
                info.put("icon", "🩸");
                info.put("search", "hematologist near me");
                break;
            case "uti": case "kidney_disease":
                info.put("specialist", "Nephrologist / Urologist");
                info.put("icon", "🫘");
                info.put("search", "urologist near me");
                break;
            case "tonsillitis": case "sinusitis": case "ear_infection":
                info.put("specialist", "ENT Specialist");
                info.put("icon", "👂");
                info.put("search", "ENT specialist near me");
                break;
            case "conjunctivitis":
                info.put("specialist", "Ophthalmologist");
                info.put("icon", "👁️");
                info.put("search", "ophthalmologist near me");
                break;
            default:
                info.put("specialist", "General Physician");
                info.put("icon", "🏥");
                info.put("search", "general physician near me");
        }
        return info;
    }
}