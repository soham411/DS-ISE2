import matplotlib.pyplot as plt
import numpy as np

errors = []
times = []
offsets = []
num = 0
init = 0
algo = input('Enter name of algo: ')
if not algo == 'ntp':
    with open(f'{algo}.txt','r') as f:
        lines = f.readlines()
        for line in lines:
            line = line.split(',')
            error = line[0]
            errors.append(float(error))
            if num == 0:
                init = float(line[1])/1000
                times.append(0)
            else:
                times.append(float(line[1])/1000-init)
            num += 1
else:
    with open(f'{algo}.txt','r') as f:
        lines = f.readlines()
        for line in lines:
            line = line.split(',')
            offset = line[0]
            offsets.append(float(offset))
            num += 1

if not algo == 'ntp':
    print(f'\nStatistics for {algo.title()} Algorithm\n')
    print(f'Total no. of sync calls: {num}\n')
    print(f'Mean Error: {np.array(errors).mean()} ms')
    print(f'Median Error: {np.median(np.array(errors))} ms')
    print(f'Standard Deviation of Errors: {round(np.array(errors).std(),4)} ms')
    print(f'Maximum Error: {np.array(errors).max()} ms')
    print(f'Minimum Error: {np.array(errors).min()} ms\n')
    print(f'Range of times: {round(max(times)-min(times),2)} seconds\n')

    with open(f'{algo}-stats.txt','w') as f:
        f.write(f'Statistics for {algo.title()} Algcristorithm\n')
        f.write(f'\nTotal no. of sync calls: {num}\n')
        f.write(f'Mean Error: {np.array(errors).mean()} ms\n')
        f.write(f'Median Error: {np.median(np.array(errors))} ms\n')
        f.write(f'Standard Deviation of Errors: {round(np.array(errors).std(),4)} ms\n')
        f.write(f'Maximum Error: {np.array(errors).max()} ms\n')
        f.write(f'Minimum Error: {np.array(errors).min()} ms\n')
        f.write(f'\nRange of times: {round(max(times)-min(times),2)} seconds')

    plt.plot(times, errors,'b')
    plt.title(f'Visualization of errors for {algo.title()} Algorithm')
    plt.xlabel('Time(seconds) since first sync call')
    plt.ylabel('Error(milliseconds)')
    plt.grid()
    plt.savefig(f'{algo}-error-plot.png')
    # plt.show()

else:
    print(f'\nStatistics for {algo.title()} Algorithm\n')
    print(f'Total no. of sync calls: {num}\n')
    print(f'Mean offset: {np.array(offsets).mean()} ms')
    print(f'Median offset: {np.median(np.array(offsets))} ms')
    print(f'Standard Deviation of offsets: {round(np.array(offsets).std(),4)} ms')
    print(f'Maximum offset: {np.array(offsets).max()} ms')
    print(f'Minimum offset: {np.array(offsets).min()} ms\n')

    with open(f'{algo}-stats.txt','w') as f:
        f.write(f'Statistics for {algo.title()} Algorithm\n')
        f.write(f'\nTotal no. of sync calls: {num}\n')
        f.write(f'Mean offset: {np.array(offsets).mean()} ms\n')
        f.write(f'Median offset: {np.median(np.array(offsets))} ms\n')
        f.write(f'Standard Deviation of offsets: {round(np.array(offsets).std(),4)} ms\n')
        f.write(f'Maximum offset: {np.array(offsets).max()} ms\n')
        f.write(f'Minimum offset: {np.array(offsets).min()} ms\n')

    plt.plot(range(num), offsets,'b')
    plt.title(f'Visualization of offsets for {algo.title()} Algorithm')
    plt.xlabel('Ticks')
    plt.ylabel('Offset(milliseconds)')
    plt.grid()
    plt.savefig(f'{algo}-error-plot.png')
    # plt.show()

errors = []
times = []
offsets = []
num = 0
init = 0
algo = input('Enter name of algo: ')
if not algo == 'ntp':
    with open(f'{algo}.txt','r') as f:
        lines = f.readlines()
        for line in lines:
            line = line.split(',')
            error = line[0]
            errors.append(float(error))
            if num == 0:
                init = float(line[1])/1000
                times.append(0)
            else:
                times.append(float(line[1])/1000-init)
            num += 1
else:
    with open(f'{algo}.txt','r') as f:
        lines = f.readlines()
        for line in lines:
            line = line.split(',')
            offset = line[0]
            offsets.append(float(offset))
            num += 1

if not algo == 'ntp':
    print(f'\nStatistics for {algo.title()} Algorithm\n')
    print(f'Total no. of sync calls: {num}\n')
    print(f'Mean Error: {np.array(errors).mean()} ms')
    print(f'Median Error: {np.median(np.array(errors))} ms')
    print(f'Standard Deviation of Errors: {round(np.array(errors).std(),4)} ms')
    print(f'Maximum Error: {np.array(errors).max()} ms')
    print(f'Minimum Error: {np.array(errors).min()} ms\n')
    print(f'Range of times: {round(max(times)-min(times),2)} seconds\n')

    with open(f'{algo}-stats.txt','w') as f:
        f.write(f'Statistics for {algo.title()} Algcristorithm\n')
        f.write(f'\nTotal no. of sync calls: {num}\n')
        f.write(f'Mean Error: {np.array(errors).mean()} ms\n')
        f.write(f'Median Error: {np.median(np.array(errors))} ms\n')
        f.write(f'Standard Deviation of Errors: {round(np.array(errors).std(),4)} ms\n')
        f.write(f'Maximum Error: {np.array(errors).max()} ms\n')
        f.write(f'Minimum Error: {np.array(errors).min()} ms\n')
        f.write(f'\nRange of times: {round(max(times)-min(times),2)} seconds')

    plt.plot(times, errors,'r')
    plt.title(f'Visualization of errors for {algo.title()} Algorithm')
    plt.xlabel('Time(seconds) since first sync call')
    plt.ylabel('Error(milliseconds)')
    plt.grid()
    plt.legend(["ntp", "cristian"], loc ="upper right")
    plt.savefig(f'{algo}-error-plot.png')
    plt.show()

else:
    print(f'\nStatistics for {algo.title()} Algorithm\n')
    print(f'Total no. of sync calls: {num}\n')
    print(f'Mean offset: {np.array(offsets).mean()} ms')
    print(f'Median offset: {np.median(np.array(offsets))} ms')
    print(f'Standard Deviation of offsets: {round(np.array(offsets).std(),4)} ms')
    print(f'Maximum offset: {np.array(offsets).max()} ms')
    print(f'Minimum offset: {np.array(offsets).min()} ms\n')

    with open(f'{algo}-stats.txt','w') as f:
        f.write(f'Statistics for {algo.title()} Algorithm\n')
        f.write(f'\nTotal no. of sync calls: {num}\n')
        f.write(f'Mean offset: {np.array(offsets).mean()} ms\n')
        f.write(f'Median offset: {np.median(np.array(offsets))} ms\n')
        f.write(f'Standard Deviation of offsets: {round(np.array(offsets).std(),4)} ms\n')
        f.write(f'Maximum offset: {np.array(offsets).max()} ms\n')
        f.write(f'Minimum offset: {np.array(offsets).min()} ms\n')

    plt.plot(range(num), offsets , 'r')
    plt.title(f'Visualization of offsets for {algo.title()} Algorithm')
    plt.xlabel('Ticks')
    plt.ylabel('Offset(milliseconds)')
    plt.grid()
    plt.legend(["ntp", "cristian"], loc ="upper right")
    plt.savefig(f'{algo}-error-plot.png')
    plt.show()