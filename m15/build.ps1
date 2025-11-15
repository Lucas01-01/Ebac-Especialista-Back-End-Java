# build.ps1 - compila e executa o projeto Java
# Uso: execute em PowerShell na raiz do projeto

function Abort($msg) {
    Write-Host "ERROR: $msg" -ForegroundColor Red
    exit 1
}

# Encontrar javac
$javac = (Get-Command javac -ErrorAction SilentlyContinue).Path
if (-not $javac) {
    $jdkCandidates = @(
        'C:\\Program Files\\Java',
        'C:\\Program Files (x86)\\Java',
        'C:\\Program Files\\AdoptOpenJDK',
        'C:\\Program Files\\Amazon Corretto',
        'C:\\Program Files\\Zulu',
        'C:\\Program Files\\Microsoft\\jdk'
    )
    foreach ($d in $jdkCandidates) {
        if (Test-Path $d) {
            Get-ChildItem $d -Directory -ErrorAction SilentlyContinue | ForEach-Object {
                $candidate = Join-Path $_.FullName 'bin\\javac.exe'
                if (Test-Path $candidate) { $javac = $candidate }
            }
        }
    }
}

if (-not $javac) { Abort 'javac não encontrado. Instale o JDK ou adicione javac ao PATH.' }

# Mostrar versão
& $javac -version

# Criar pasta de saída
$outDir = Join-Path (Get-Location) 'out'
if (-not (Test-Path $outDir)) { New-Item -ItemType Directory -Path $outDir | Out-Null }

# Listar e compilar fontes
$files = Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName }
if (-not $files) { Abort 'Nenhum arquivo .java encontrado.' }

Write-Host 'Compilando fontes...'
& $javac -d $outDir $files
if ($LASTEXITCODE -ne 0) { Abort 'Erro na compilação.' }

Write-Host 'Compilação concluída.' -ForegroundColor Green

# Executar: prefira java.exe que está ao lado de javac (mesmo JDK) para evitar mismatch
$javaCandidate = $javac -replace 'javac.exe','java.exe'
$javaSystem = (Get-Command java -ErrorAction SilentlyContinue).Path
if (Test-Path $javaCandidate) {
    $java = $javaCandidate
    Write-Host "Usando java de: $java" -ForegroundColor Yellow
} elseif ($javaSystem) {
    $java = $javaSystem
    Write-Host "Usando java encontrado no PATH: $java" -ForegroundColor Yellow
} else {
    Abort 'java não encontrado após compilação.'
}

Write-Host 'Executando app.Main...' -ForegroundColor Cyan
& $java -cp $outDir app.Main

Write-Host 'Execução finalizada.' -ForegroundColor Green
