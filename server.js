const express = require('express');
const fs = require('fs');
const path = require('path');

const app = express();
const PORT = process.env.PORT || 3000;
const DATA_FILE = path.join(__dirname, 'data', 'messages.json');

app.use(express.json({ limit: '1mb' }));
app.use(express.static(__dirname));

const profile = {
  name: 'Ali Öner Filibeli',
  title: 'Yönetim Bilişim Sistemleri Uzmanı & Developer',
  email: 'filibelialioner@gmail.com',
  phone: '+90 530 112 9841',
  location: 'Karamürsel, Kocaeli, Türkiye',
  github: 'https://github.com/oner98',
  linkedin: 'https://linkedin.com/in/ali-öner-filibeli-5086b82b8',
  skills: [
    'Java', 'Python', 'C#', 'Kotlin', 'Spring Boot', '.NET Core',
    'MySQL', 'PostgreSQL', 'AWS', 'Azure', 'Docker', 'Kubernetes',
    'İngilizce (C1)', 'Almanca'
  ]
};

const projects = [
  { title: 'Serverless Booking', stack: ['AWS', 'Lambda', 'DynamoDB'], description: 'Etkinlik rezervasyon süreçlerini otomatikleştiren serverless yapı.' },
  { title: 'Expense Tracker', stack: ['Kotlin', 'Android', 'Analytics'], description: 'Mobil kullanıcı odaklı harcama takibi ve veri analizi uygulaması.' },
  { title: 'Weather App', stack: ['REST', 'Firebase', 'Caching'], description: 'API tabanlı hava durumu uygulaması.' },
  { title: 'School Management', stack: ['Java', 'Spring', 'MySQL'], description: 'Öğrenci, öğretmen ve not yönetimini tek bir sistemde birleştiren kurumsal uygulama.' },
  { title: 'Smart Inventory', stack: ['C#', '.NET', 'PostgreSQL'], description: 'Stok takibi ve operasyonel raporlamaya odaklı kurumsal çözüm.' },
  { title: 'AI Task Assistant', stack: ['Python', 'FastAPI', 'Automation'], description: 'Görev planlama ve otomasyon mantığı sunan yardımcı sistem.' },
  { title: 'Cloud Deploy Monitor', stack: ['Azure', 'Monitoring', 'DevOps'], description: 'Dağıtım izleme ve hata takibi için bulut monitör çözümü.' },
  { title: 'Microservice Gateway', stack: ['Docker', 'Kubernetes', 'Microservices'], description: 'Mikroservisler arası yönlendirme ve servis yönetimi.' },
  { title: 'Data Insight Hub', stack: ['SQL', 'Analytics', 'Reporting'], description: 'Veri analizi ve karar destek raporlaması için arayüz.' }
];

const ensureDataFile = () => {
  if (!fs.existsSync(DATA_FILE)) {
    fs.mkdirSync(path.dirname(DATA_FILE), { recursive: true });
    fs.writeFileSync(DATA_FILE, '[]', 'utf8');
  }
};

const readMessages = () => {
  ensureDataFile();
  try {
    const raw = fs.readFileSync(DATA_FILE, 'utf8');
    const parsed = JSON.parse(raw);
    return Array.isArray(parsed) ? parsed : [];
  } catch (error) {
    return [];
  }
};

const writeMessages = (messages) => {
  ensureDataFile();
  fs.writeFileSync(DATA_FILE, JSON.stringify(messages, null, 2), 'utf8');
};

app.get('/api/profile', (req, res) => {
  res.json(profile);
});

app.get('/api/projects', (req, res) => {
  res.json(projects);
});

app.get('/api/contact-messages', (req, res) => {
  res.json(readMessages());
});

app.post('/api/contact', (req, res) => {
  const { name, email, message } = req.body || {};

  if (!name || !email || !message) {
    return res.status(400).json({ success: false, message: 'Ad, e-posta ve mesaj alanları zorunludur.' });
  }

  const trimmedName = String(name).trim();
  const trimmedEmail = String(email).trim();
  const trimmedMessage = String(message).trim();

  if (trimmedName.length < 2 || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(trimmedEmail) || trimmedMessage.length < 10) {
    return res.status(400).json({ success: false, message: 'Lütfen bilgileri doğru formda girin.' });
  }

  const newMessage = {
    id: Date.now(),
    name: trimmedName,
    email: trimmedEmail,
    message: trimmedMessage,
    createdAt: new Date().toISOString()
  };

  const messages = readMessages();
  messages.unshift(newMessage);
  writeMessages(messages);

  return res.status(200).json({ success: true, message: 'Mesajınız başarıyla alındı. En kısa zamanda dönüş yapacağım.' });
});

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index.html'));
});

app.listen(PORT, () => {
  console.log(`Portfolio backend running at http://localhost:${PORT}`);
});
