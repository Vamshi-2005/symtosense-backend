/* ══════════════════════════════════════
   SymtoSense — Frontend JS
   ══════════════════════════════════════ */

// ── History Helpers ───────────────────────────────
function saveToHistory(symptoms) {
    const history = JSON.parse(localStorage.getItem('symptom_history') || '[]');
    const entry = {
        symptoms: symptoms,
        time: new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }),
        date: new Date().toLocaleDateString()
    };
    const filtered = history.filter(h => h.symptoms !== symptoms);
    filtered.unshift(entry);
    localStorage.setItem('symptom_history', JSON.stringify(filtered.slice(0, 5)));
}

function loadHistory() {
    return JSON.parse(localStorage.getItem('symptom_history') || '[]');
}

function renderHistory() {
    const history = loadHistory();
    const container = document.getElementById('historyList');
    const section = document.getElementById('historySection');
    if (!container || !section) return;

    if (history.length === 0) {
        section.style.display = 'none';
        return;
    }

    section.style.display = 'block';
    container.innerHTML = '';

    history.forEach(entry => {
        const item = document.createElement('div');
        item.className = 'history-item';
        item.innerHTML = `
            <div class="history-symptoms">${entry.symptoms.replace(/_/g, ' ')}</div>
            <div class="history-time">${entry.date} · ${entry.time}</div>
        `;
        item.addEventListener('click', () => {
            const input = document.getElementById('symptomInput');
            if (input) {
                input.value = entry.symptoms;
                input.dispatchEvent(new Event('input'));
                input.focus();
                window.scrollTo({ top: 0, behavior: 'smooth' });
            }
        });
        container.appendChild(item);
    });
}

document.addEventListener('DOMContentLoaded', function () {

    const input = document.getElementById('symptomInput');
    const tags = document.querySelectorAll('.tag');
    const form = document.getElementById('symptomForm');
    const analyzeBtn = document.getElementById('analyzeBtn');
    const selectedPreview = document.getElementById('selectedPreview');
    const selectedChips = document.getElementById('selectedChips');
    const clearBtn = document.getElementById('clearBtn');

    if (!input) return;

    let selectedSymptoms = new Set();

    // ── Render history on load ────────────────────
    renderHistory();

    // ── Tag click ─────────────────────────────────
    tags.forEach(tag => {
        tag.addEventListener('click', () => {
            const symptom = tag.dataset.symptom;
            if (selectedSymptoms.has(symptom)) {
                selectedSymptoms.delete(symptom);
                tag.classList.remove('active');
            } else {
                selectedSymptoms.add(symptom);
                tag.classList.add('active');
            }
            syncInputFromTags();
            updateSelectedPreview();
        });
    });

    // ── Sync input → tag state ────────────────────
    input.addEventListener('input', () => {
        const vals = input.value
            .split(',')
            .map(s => s.trim().toLowerCase().replace(/\s+/g, '_'))
            .filter(Boolean);
        selectedSymptoms = new Set(vals);
        tags.forEach(tag => {
            tag.classList.toggle('active', selectedSymptoms.has(tag.dataset.symptom));
        });
        updateSelectedPreview();
    });

    // ── Clear ─────────────────────────────────────
    if (clearBtn) {
        clearBtn.addEventListener('click', () => {
            selectedSymptoms.clear();
            input.value = '';
            tags.forEach(t => t.classList.remove('active'));
            updateSelectedPreview();
        });
    }

    // ── Form submit with loading screen ──────────
    if (form) {
        form.addEventListener('submit', function (e) {
            const val = input.value.trim();
            if (!val) {
                e.preventDefault();
                input.focus();
                shakeInput();
                return;
            }
            e.preventDefault();
            saveToHistory(val);
            showLoadingScreen(val);
        });
    }

    // ── Loading Screen ────────────────────────────
    function showLoadingScreen(symptoms) {
        const overlay = document.createElement('div');
        overlay.id = 'loadingOverlay';
        overlay.innerHTML = `
            <div class="loading-box">
                <div class="loading-dna">🧬</div>
                <h2 class="loading-title">Analyzing Symptoms</h2>
                <p class="loading-symptoms">${symptoms.replace(/_/g, ' ')}</p>
                <div class="loading-bar-wrap">
                    <div class="loading-bar" id="loadingBar"></div>
                </div>
                <div class="loading-steps">
                    <span class="loading-step active" id="step1">🔍 Reading symptoms</span>
                    <span class="loading-step" id="step2">🤖 Running ML model</span>
                    <span class="loading-step" id="step3">📊 Calculating confidence</span>
                </div>
            </div>
        `;
        document.body.appendChild(overlay);

        setTimeout(() => {
            document.getElementById('loadingBar').style.width = '35%';
            document.getElementById('step1').classList.add('done');
            document.getElementById('step2').classList.add('active');
        }, 600);

        setTimeout(() => {
            document.getElementById('loadingBar').style.width = '70%';
            document.getElementById('step2').classList.add('done');
            document.getElementById('step3').classList.add('active');
        }, 1200);

        setTimeout(() => {
            document.getElementById('loadingBar').style.width = '100%';
            document.getElementById('step3').classList.add('done');
        }, 1800);

        setTimeout(() => { form.submit(); }, 2000);
    }

    // ── Helpers ───────────────────────────────────
    function syncInputFromTags() {
        input.value = [...selectedSymptoms].join(', ');
    }

    function updateSelectedPreview() {
        if (!selectedPreview || !selectedChips) return;
        if (selectedSymptoms.size === 0) {
            selectedPreview.style.display = 'none';
            return;
        }
        selectedPreview.style.display = 'flex';
        selectedChips.innerHTML = '';
        selectedSymptoms.forEach(s => {
            const chip = document.createElement('span');
            chip.className = 'selected-chip';
            chip.textContent = s.replace(/_/g, ' ');
            selectedChips.appendChild(chip);
        });
    }

    function shakeInput() {
        const wrapper = input.closest('.input-wrapper');
        if (!wrapper) return;
        wrapper.style.animation = 'none';
        wrapper.offsetHeight;
        wrapper.style.animation = 'shake 0.4s ease';
        wrapper.addEventListener('animationend', () => {
            wrapper.style.animation = '';
        }, { once: true });
    }

    // ── Inject styles ─────────────────────────────
    const style = document.createElement('style');
    style.textContent = `
        @keyframes shake {
            0%,100% { transform: translateX(0); }
            20% { transform: translateX(-6px); }
            40% { transform: translateX(6px); }
            60% { transform: translateX(-4px); }
            80% { transform: translateX(4px); }
        }

        #loadingOverlay {
            position: fixed;
            inset: 0;
            background: rgba(10, 14, 26, 0.97);
            backdrop-filter: blur(20px);
            z-index: 9999;
            display: flex;
            align-items: center;
            justify-content: center;
            animation: fadeIn 0.3s ease;
        }

        @keyframes fadeIn {
            from { opacity: 0; }
            to   { opacity: 1; }
        }

        .loading-box {
            text-align: center;
            padding: 48px;
            background: rgba(255,255,255,0.05);
            border: 1px solid rgba(255,255,255,0.1);
            border-radius: 32px;
            max-width: 440px;
            width: 90%;
        }

        .loading-dna {
            font-size: 56px;
            animation: pulse 1s ease-in-out infinite;
            display: block;
            margin-bottom: 20px;
        }

        @keyframes pulse {
            0%,100% { transform: scale(1); }
            50%      { transform: scale(1.2); }
        }

        .loading-title {
            font-family: 'Space Grotesk', sans-serif;
            font-size: 26px;
            font-weight: 700;
            color: #f0f4ff;
            margin-bottom: 8px;
        }

        .loading-symptoms {
            font-size: 14px;
            color: #4f8ef7;
            margin-bottom: 28px;
            font-weight: 500;
            text-transform: capitalize;
        }

        .loading-bar-wrap {
            height: 6px;
            background: rgba(255,255,255,0.08);
            border-radius: 4px;
            overflow: hidden;
            margin-bottom: 28px;
        }

        .loading-bar {
            height: 100%;
            width: 0%;
            background: linear-gradient(90deg, #4f8ef7, #a855f7);
            border-radius: 4px;
            transition: width 0.6s cubic-bezier(0.4, 0, 0.2, 1);
        }

        .loading-steps {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .loading-step {
            font-size: 14px;
            color: #64748b;
            padding: 8px 16px;
            border-radius: 12px;
            transition: all 0.3s ease;
            font-weight: 500;
        }

        .loading-step.active {
            color: #f0f4ff;
            background: rgba(79,142,247,0.1);
            border: 1px solid rgba(79,142,247,0.2);
        }

        .loading-step.done {
            color: #22c55e;
            background: rgba(34,197,94,0.08);
            border: 1px solid rgba(34,197,94,0.2);
        }

        /* ── History Section ── */
        #historySection {
            margin-bottom: 24px;
            animation: fadeUp 0.6s ease 0.3s both;
        }

        .history-header {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-bottom: 12px;
        }

        .history-title {
            font-size: 13px;
            font-weight: 600;
            color: #64748b;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .history-clear {
            font-size: 12px;
            color: #f87171;
            cursor: pointer;
            background: none;
            border: none;
            font-family: inherit;
            padding: 2px 8px;
            border-radius: 8px;
            transition: background 0.2s;
        }

        .history-clear:hover {
            background: rgba(248,113,113,0.1);
        }

        .history-list {
            display: flex;
            flex-direction: column;
            gap: 8px;
        }

        .history-item {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 12px 16px;
            background: rgba(255,255,255,0.04);
            border: 1px solid rgba(255,255,255,0.07);
            border-radius: 12px;
            cursor: pointer;
            transition: all 0.2s;
        }

        .history-item:hover {
            background: rgba(79,142,247,0.08);
            border-color: rgba(79,142,247,0.2);
        }

        .history-symptoms {
            font-size: 14px;
            color: #94a3b8;
            font-weight: 500;
            text-transform: capitalize;
        }

        .history-time {
            font-size: 11px;
            color: #475569;
            flex-shrink: 0;
            margin-left: 12px;
        }
    `;
    document.head.appendChild(style);

});