# Create output directory if it doesn't exist
if (-not (Test-Path -Path out)) {
    New-Item -ItemType Directory -Path out | Out-Null
}

# Compile all Java files in src directory to out directory
javac -d out ./src/*.java

# Check if compilation was successful
if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful"
    # Run the main class
    java -cp out Main
} else {
    Write-Host "Compilation failed"
    exit 1
}
